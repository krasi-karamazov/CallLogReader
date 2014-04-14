package kpk.dev.calllogreader.calllogreader.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import kpk.dev.calllogreader.calllogreader.R;
import kpk.dev.calllogreader.calllogreader.util.Constants;
import kpk.dev.calllogreader.calllogreader.util.validation.AbstractValidationUnit;
import kpk.dev.calllogreader.calllogreader.util.validation.Form;
import kpk.dev.calllogreader.calllogreader.util.validation.ValidationUnitImlp;
import kpk.dev.calllogreader.calllogreader.util.validation.validators.EmailValidator;
import kpk.dev.calllogreader.calllogreader.util.validation.validators.EmptyValidator;

/**
 * Created by krasimir.karamazov on 4/14/2014.
 */
public class RegisterFragment extends BaseFragment {

    public static final String TAG = RegisterFragment.class.getSimpleName();
    private Form mForm;
    private EditText mMailField;
    private SharedPreferences mPrefs;

    public static RegisterFragment getInstance(Bundle args) {
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initUI(View rootView) {
        mMailField = (EditText)rootView.findViewById(R.id.et_mail);
        final String regMail = getRegisteredMail();
        if(!TextUtils.isEmpty(getRegisteredMail())) {
            mMailField.setText(regMail);
        }

       rootView.findViewById(R.id.but_register).setOnClickListener(getOnClickListener());
       setupValidation();
    }

    @Override
    protected String getTitle() {
        return getString(R.string.register_email_title);
    }

    private View.OnClickListener getOnClickListener() {
        return new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(mForm.isValid()) {
                    mPrefs.edit()
                            .putString(Constants.REGISTERED_MAIL_PREFS_KEY, mMailField.getText().toString())
                            .commit();
                    InputMethodManager inputManager = (InputMethodManager)
                            getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    //goto main fragment
                }
            }
        };
    }

    private void setupValidation() {
        mForm = new Form();
        AbstractValidationUnit email = new ValidationUnitImlp(mMailField);
        email.addValidator(new EmailValidator(getActivity()));
        email.addValidator(new EmptyValidator(getActivity()));
        mForm.addValidationUnit(email);
    }

    private String getRegisteredMail() {
        mPrefs = getActivity().getSharedPreferences(Constants.PREFS_FILE, Activity.MODE_PRIVATE);
        if(mPrefs.contains(Constants.REGISTERED_MAIL_PREFS_KEY)) {
            return mPrefs.getString(Constants.REGISTERED_MAIL_PREFS_KEY, "");
        }else{
            return "";
        }
    }
}
