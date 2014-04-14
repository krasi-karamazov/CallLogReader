package kpk.dev.calllogreader.calllogreader.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by krasimir.karamazov on 4/14/2014.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(),container, false);
        initUI(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setRetainInstance(true);
        ((ActionBarActivity)getActivity()).getSupportActionBar().setTitle(getTitle());
    }

    protected abstract int getLayoutId();
    protected abstract void initUI(View rootView);
    protected abstract String getTitle();
}
