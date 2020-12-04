package com.example.contacttest2;

import java.util.ArrayList;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.accounts.OnAccountsUpdateListener;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		OnAccountsUpdateListener, OnItemSelectedListener, OnClickListener {

	private ArrayList<AccountData> mAccounts;
	private AccountAdapter mAccountAdapter;
	private Spinner mAccountSpinner;
	private AccountData mSelectedAccount;

	private EditText mContactNameEditText;

	private EditText mContactEmailEditTextOne;

	private EditText mContactPhoneEditTextOne;
	private EditText mContactPhoneEditTextTwo;
	private EditText mContactFaxEditText;

	private EditText mContactCompanyEditText;
	private EditText mContactDeptEditText;
	private EditText mContactJobTitleEditText;

	private EditText mContactZipCodeEditText;
	private EditText mContactAddressEditText;
	private EditText mContactWebSiteEditText;
	private EditText mContactMemoEditText;
	private Button mContactSaveButton;

	private String mGroupId;
	private String mGroupName;

	private Spinner mGroupSpinner;

	// layout
	private int mLayoutAccountEntry;

	private int mIdFirstAccountLine;
	private int mIdSecondAccountLine;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mAccountSpinner = (Spinner) findViewById(R.id.ve_act_bas_con_accountSpinner);
		mContactNameEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactNameEditText);
		mContactPhoneEditTextOne = (EditText) findViewById(R.id.ve_act_bas_con_contactPhoneEditTextOne);
		mContactPhoneEditTextTwo = (EditText) findViewById(R.id.ve_act_bas_con_contactPhoneEditTextTwo);
		mContactEmailEditTextOne = (EditText) findViewById(R.id.ve_act_bas_con_contactEmailEditTextOne);
		mContactFaxEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactFaxEditText);

		mContactCompanyEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactCompanyEditText);
		mContactDeptEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactDeptEditText);
		mContactJobTitleEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactJobTitleEditText);
		mContactZipCodeEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactZipcodeEditText);
		mContactAddressEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactAddressEditText);
		mContactWebSiteEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactWebsiteEditText);
		mContactMemoEditText = (EditText) findViewById(R.id.ve_act_bas_con_contactMemoEditText);
		mContactSaveButton = (Button) findViewById(R.id.contactSaveButton);

		mGroupSpinner = (Spinner) findViewById(R.id.ve_act_bas_con_groupSpinner);

		// Prepare model for account spinner
		mAccounts = new ArrayList<AccountData>();
		mAccountAdapter = new AccountAdapter(this, mAccounts);
		mAccountSpinner.setAdapter(mAccountAdapter);

		// Populate list of account types for phone
		ArrayAdapter<String> adapter;
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		AccountManager.get(getApplicationContext())
				.addOnAccountsUpdatedListener(this, null, true);

		// Register handlers for UI elements
		mAccountSpinner.setOnItemSelectedListener(this);

		if (mContactSaveButton != null)
			mContactSaveButton.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {

		int nId = v.getId();

		if (nId == R.id.contactSaveButton) {
			SaveContact();
			Toast.makeText(getApplicationContext(), "연락처가 추가 되었습니다.",
					Toast.LENGTH_LONG).show();
		}

	}

	private void SaveContact() {

		createContactEntry();

		finish();
	}

	/**
	 * Spinner 위젯 선택 이벤트 핸들러
	 */
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		int nId = parent.getId();
		if (nId == R.id.ve_act_bas_con_accountSpinner) {
			updateAccountSelection();
		}

		else if (nId == R.id.ve_act_bas_con_groupSpinner) {
			if (parent.getItemAtPosition(position) != null) {
				Cursor cursor = (Cursor) parent.getItemAtPosition(position);

				if (cursor != null) {
					mGroupId = cursor.getString(cursor
							.getColumnIndex(ContactsContract.Groups._ID));
					mGroupName = cursor.getString(cursor
							.getColumnIndex(ContactsContract.Groups.TITLE));
				}
			}
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 계정 선택에 따른 계정별 그룹 정보 업데이트
	 * 
	 * @param accName
	 * @param accType
	 */
	private void updateGroupSpinner(String accName, String accType) {
		String[] GROUP_PROJECTION = new String[] { ContactsContract.Groups._ID, // 0
				ContactsContract.Groups.TITLE, // 1
		};

		Spinner groupSpinner = (Spinner) findViewById(R.id.ve_act_bas_con_groupSpinner);

		if (groupSpinner != null)
			groupSpinner.setPrompt("그룹을 선택하십시오.");

		Cursor groupCursor = getGroupCursor(this, accName, accType);

		LinearLayout grouplayout = (LinearLayout) findViewById(R.id.ve_act_bas_con_grouplayout);

		if (groupCursor.getCount() > 0) {
			SimpleCursorAdapter groupAdapter = new SimpleCursorAdapter(this,
					android.R.layout.simple_spinner_item, groupCursor,
					GROUP_PROJECTION, new int[] { android.R.id.text2,
							android.R.id.text1 });
			groupAdapter
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			groupSpinner.setAdapter(groupAdapter);

			groupSpinner.setOnItemSelectedListener(this);

			// 그룹이 있는 Group UI 활성 처리
			if (grouplayout != null)
				grouplayout.setVisibility(LinearLayout.VISIBLE);
		} else {
			// 그룹이 없는 경우 Group UI 비활성 처리
			if (grouplayout != null)
				grouplayout.setVisibility(LinearLayout.GONE);
		}

	}

	/**
	 * 그룹 정보 조회
	 * 
	 * @param context
	 * @param accName
	 * @param accType
	 * @return
	 */
	private Cursor getGroupCursor(Context context, String accName,
			String accType) {
		String[] GROUP_PROJECTION = new String[] { ContactsContract.Groups._ID, // 0
				ContactsContract.Groups.TITLE, // 1
		};
		Cursor cursor = context.getContentResolver().query(
				ContactsContract.Groups.CONTENT_URI,
				GROUP_PROJECTION,
				ContactsContract.Groups.DELETED + " = 0 " + " AND "
						+ ContactsContract.Groups.GROUP_VISIBLE + " = 1 "
						+ " AND " + ContactsContract.Groups.ACCOUNT_NAME
						+ " = '" + accName + "' AND "
						+ ContactsContract.Groups.ACCOUNT_TYPE + " = '"
						+ accType + "' ", null,
				ContactsContract.Groups.TITLE + " COLLATE LOCALIZED ASC");

		return cursor;
	}

	private Cursor getExistContactQuery(Context context, String strName) {
		String[] strProjection = new String[] { ContactsContract.Contacts.DISPLAY_NAME };
		String strSelection = ContactsContract.Contacts.DISPLAY_NAME + "=?";
		Cursor c = context.getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, strProjection,
				strSelection, new String[] { strName }, null /*
															 * ContactsContract.
															 * Contacts
															 * .DISPLAY_NAME +
															 * " COLLATE LOCALIZED ASC"
															 */);

		return c;
	}

	public void createContactEntry() {
		String strName = null; // 이름
		String strPhoneOne = null; // 전화번호
		String strPhoneTwo = null;
		String strPhoneFax = null; // 팩스번호
		String strEmailOne = null; // 이메일
		String strCompanyName = null; // 회사명
		String strDeptName = null; // 부서명
		String strJobTitle = null; // 직책명
		String strZipcode = null; // 우편번호
		String strAddress = null; // 주소
		String strWebsite = null; // 홈페이지
		String strMemo = null; // 메모 (키워드)

		// 이름

		strName = mContactNameEditText.getText().toString();
		strPhoneOne = mContactPhoneEditTextOne.getText().toString();
		strPhoneTwo = mContactPhoneEditTextTwo.getText().toString();
		strPhoneFax = mContactFaxEditText.getText().toString();
		strEmailOne = mContactEmailEditTextOne.getText().toString();
		strCompanyName = mContactCompanyEditText.getText().toString();
		strDeptName = mContactDeptEditText.getText().toString();
		strJobTitle = mContactJobTitleEditText.getText().toString();
		strZipcode = mContactZipCodeEditText.getText().toString();
		strAddress = mContactAddressEditText.getText().toString();
		strWebsite = mContactWebSiteEditText.getText().toString();
		strMemo = mContactMemoEditText.getText().toString();

		// 계정 정보 획득 / 주소록 결합 모드 설정
		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

		String strAccountType = "";
		String strAccountName = "";

		if (mAccounts.size() == 0) {
			strAccountType = null;
			strAccountName = null;
		} else {
			strAccountType = mSelectedAccount.getType();
			strAccountName = mSelectedAccount.getName();
		}

		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.RawContacts.CONTENT_URI)
				.withValue(ContactsContract.RawContacts.ACCOUNT_TYPE,
						strAccountType)
				.withValue(ContactsContract.RawContacts.ACCOUNT_NAME,
						strAccountName)
				.withValue(ContactsContract.RawContacts.AGGREGATION_MODE,
						ContactsContract.RawContacts.AGGREGATION_MODE_DISABLED)
				.build());
		// 이름
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
				.withValue(
						ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,
						strName).build());
		// 핸드폰
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,
						strPhoneOne)
				.withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
						ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
				.build());
		// 전화번호
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,
						strPhoneTwo)
				.withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
						ContactsContract.CommonDataKinds.Phone.TYPE_WORK)
				.build());

		// 팩스번호
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Phone.NUMBER,
						strPhoneFax)
				.withValue(ContactsContract.CommonDataKinds.Phone.TYPE,
						ContactsContract.CommonDataKinds.Phone.TYPE_FAX_WORK)
				.build());

		// 이메일
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Email.DATA,
						strEmailOne)
				.withValue(ContactsContract.CommonDataKinds.Email.TYPE,
						ContactsContract.CommonDataKinds.Email.TYPE_WORK)
				.build());

		// 회사명 , 직함
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)
				.withValue(
						ContactsContract.CommonDataKinds.Organization.COMPANY,
						strCompanyName)
				.withValue(ContactsContract.CommonDataKinds.Organization.TYPE,
						ContactsContract.CommonDataKinds.Organization.TYPE_WORK)
				.withValue(ContactsContract.CommonDataKinds.Organization.TITLE,
						strJobTitle).build());

		// 부서
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Organization.CONTENT_ITEM_TYPE)
				.withValue(
						ContactsContract.CommonDataKinds.Organization.TYPE,
						ContactsContract.CommonDataKinds.Organization.TYPE_CUSTOM)
				.withValue(ContactsContract.CommonDataKinds.Organization.LABEL,
						"부서")
				.withValue(ContactsContract.CommonDataKinds.Organization.DATA,
						strDeptName).build());
		// 우편번호
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
				.withValue(
						ContactsContract.CommonDataKinds.StructuredPostal.TYPE,
						ContactsContract.CommonDataKinds.StructuredPostal.TYPE_WORK)
				.withValue(
						ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE,
						strZipcode)
				.withValue(
						ContactsContract.CommonDataKinds.StructuredPostal.STREET,
						strAddress).build());

		// 홈페이지
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(
						ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Website.URL,
						strWebsite)
				.withValue(ContactsContract.CommonDataKinds.Website.TYPE,
						ContactsContract.CommonDataKinds.Website.TYPE_HOMEPAGE)
				.build());

		// 키워드(메모)
		ops.add(ContentProviderOperation
				.newInsert(ContactsContract.Data.CONTENT_URI)
				.withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, 0)
				.withValue(ContactsContract.Data.MIMETYPE,
						ContactsContract.CommonDataKinds.Note.CONTENT_ITEM_TYPE)
				.withValue(ContactsContract.CommonDataKinds.Note.NOTE, strMemo)
				.build());

		try {
			getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onDestroy() {
		// Remove AccountManager callback
		AccountManager.get(this).removeOnAccountsUpdatedListener(this);
		super.onDestroy();
	}

	/**
	 * Updates account list spinner when the list of Accounts on the system
	 * changes. Satisfies OnAccountsUpdateListener implementation.
	 */
	@Override
	public void onAccountsUpdated(Account[] a) {
		// Clear out any old data to prevent duplicates
		mAccounts.clear();

		// Get account data from system
		AuthenticatorDescription[] accountTypes = AccountManager.get(this)
				.getAuthenticatorTypes();

		// Populate tables
		for (int i = 0; i < a.length; i++) {
			// The user may have multiple accounts with the same name, so we
			// need to construct a
			// meaningful display name for each.
			String systemAccountType = a[i].type;
			AuthenticatorDescription ad = getAuthenticatorDescription(
					systemAccountType, accountTypes);
			AccountData data = new AccountData(a[i].name, ad);
			mAccounts.add(data);
		}

		// 계정이 없는 경우 계정UI, 그룹 UI 비활성 처리
		if (mAccounts.size() == 0) {
			LinearLayout layout = (LinearLayout) findViewById(R.id.ve_act_bas_con_accountlayout);
			LinearLayout grouplayout = (LinearLayout) findViewById(R.id.ve_act_bas_con_grouplayout);

			if (layout != null)
				layout.setVisibility(LinearLayout.GONE);

			if (grouplayout != null)
				grouplayout.setVisibility(LinearLayout.GONE);
		}

		// Update the account spinner
		mAccountAdapter.notifyDataSetChanged();

	}

	/**
	 * Obtain the AuthenticatorDescription for a given account type.
	 * 
	 * @param type
	 *            The account type to locate.
	 * @param dictionary
	 *            An array of AuthenticatorDescriptions, as returned by
	 *            AccountManager.
	 * @return The description for the specified account type.
	 */

	private static AuthenticatorDescription getAuthenticatorDescription(
			String type, AuthenticatorDescription[] dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].type.equals(type)) {
				return dictionary[i];
			}
		}
		// No match found
		throw new RuntimeException("Unable to find matching authenticator");
	}

	/**
	 * Update account selection. If NO_ACCOUNT is selected, then we prohibit
	 * inserting new contacts.
	 */
	private void updateAccountSelection() {
		// Read current account selection
		mSelectedAccount = (AccountData) mAccountSpinner.getSelectedItem();
		updateGroupSpinner(mSelectedAccount.getName(),
				mSelectedAccount.getType());
	}

	private class AccountData {
		private String mName;
		private String mType;
		private CharSequence mTypeLabel;

		/**
		 * @param name
		 *            The name of the account. This is usually the user's email
		 *            address or username.
		 * @param description
		 *            The description for this account. This will be dictated by
		 *            the type of account returned, and can be obtained from the
		 *            system AccountManager.
		 */
		public AccountData(String name, AuthenticatorDescription description) {
			mName = name;
			if (description != null) {
				mType = description.type;

				// The type string is stored in a resource, so we need to
				// convert it into something
				// human readable.
				String packageName = description.packageName;
				PackageManager pm = getPackageManager();

				if (description.labelId != 0) {
					mTypeLabel = pm.getText(packageName, description.labelId,
							null);
					if (mTypeLabel == null) {
						throw new IllegalArgumentException(
								"LabelID provided, but label not found");
					}
				} else {
					mTypeLabel = "";
				}

				if (description.iconId != 0) {
					// mIcon = pm.getDrawable(packageName, description.iconId,
					// null);
					// if( mIcon == null )
					// {
					// throw new
					// IllegalArgumentException("IconID provided, but drawable not found");
					// }
				} else {
					// mIcon =
					// getResources().getDrawable(android.R.drawable.sym_def_app_icon);
				}
			}
		}

		public String getName() {
			return mName;
		}

		public String getType() {
			return mType;
		}

		public CharSequence getTypeLabel() {
			return mTypeLabel;
		}

		@Override
		public String toString() {
			return mName;
		}
	}

	/**
	 * Custom adapter used to display account icons and descriptions in the
	 * account spinner.
	 */
	private class AccountAdapter extends ArrayAdapter<AccountData> {
		public AccountAdapter(Context context,
				ArrayList<AccountData> accountData) {
			super(context, android.R.layout.simple_spinner_item, accountData);
			setDropDownViewResource(R.layout.account_entry);
		}

		@Override
		public View getDropDownView(int position, View convertView,
				ViewGroup parent) {
			// Inflate a view template
			if (convertView == null) {
				LayoutInflater layoutInflater = getLayoutInflater();
				convertView = layoutInflater.inflate(R.layout.account_entry,
						parent, false);
			}
			TextView firstAccountLine = (TextView) convertView
					.findViewById(R.id.ve_act_bas_con_firstAccountLine);
			TextView secondAccountLine = (TextView) convertView
					.findViewById(R.id.ve_act_bas_con_secondAccountLine);

			// Populate template
			AccountData data = getItem(position);

			if (firstAccountLine != null)
				firstAccountLine.setText(data.getName());

			if (secondAccountLine != null)
				secondAccountLine.setText(data.getTypeLabel());

			return convertView;
		}

	}
}
