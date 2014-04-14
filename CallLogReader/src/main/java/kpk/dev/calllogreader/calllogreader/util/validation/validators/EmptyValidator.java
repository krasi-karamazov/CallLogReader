package kpk.dev.calllogreader.calllogreader.util.validation.validators;

/**
 * Created by krasimir.karamazov on 4/10/2014.
 */
import android.content.Context;
import android.text.TextUtils;

import kpk.dev.calllogreader.calllogreader.R;
import kpk.dev.calllogreader.calllogreader.util.validation.AbstractValidator;

public class EmptyValidator extends AbstractValidator {

    public EmptyValidator(Context context) {
        super(context);
    }

    @Override
    public boolean isValid(CharSequence value) {
        return !TextUtils.isEmpty(value);
    }

    @Override
    protected int getConcreteMessageId() {
        return R.string.validation_empty_error;
    }

}
