package kpk.dev.calllogreader.calllogreader.util.validation.validators;

/**
 * Created by krasimir.karamazov on 2/28/14.
 */

import android.content.Context;

import java.util.regex.Pattern;

import kpk.dev.calllogreader.calllogreader.R;
import kpk.dev.calllogreader.calllogreader.util.validation.AbstractValidator;


public class EmailValidator extends AbstractValidator {
    private Pattern mPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    public EmailValidator(Context context) {
        super(context);
    }

    @Override
    public boolean isValid(CharSequence value) {
        return mPattern.matcher(value).matches();
    }

    @Override
    protected int getConcreteMessageId() {
        return R.string.email_validation_error;
    }

}
