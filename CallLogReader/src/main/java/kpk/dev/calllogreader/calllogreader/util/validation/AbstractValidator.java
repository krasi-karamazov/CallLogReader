package kpk.dev.calllogreader.calllogreader.util.validation;

/**
 * Created by krasimir.karamazov on 2/28/14.
 */
import android.content.Context;

public abstract class AbstractValidator {
    private Context mContext;
    private String mMessage;
    public AbstractValidator(Context context) {
        mContext = context;
        setMessage();
    }
    public abstract boolean isValid(CharSequence value);
    protected abstract int getConcreteMessageId();

    protected void setMessage() {
        mMessage = mContext.getString(getConcreteMessageId());
    }

    public String getMessage() {
        return mMessage;
    }
}

