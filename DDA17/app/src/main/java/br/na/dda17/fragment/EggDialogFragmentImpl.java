package br.na.dda17.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import br.na.dda17.R;

public class EggDialogFragmentImpl extends DialogFragment implements TextView.OnEditorActionListener {

    private EditText mEditText;


    public interface UserNameListener {
        void onFinishUserDialog(String user);
    }

    // Empty constructor required for DialogFragment
    //public EggDialogFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_egg, container);
        mEditText = (EditText) view.findViewById(R.id.username);

        // set this instance as callback for editor action
        mEditText.setOnEditorActionListener(this);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle("Please enter username");

        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // Return input text to activity
        UserNameListener activity = (UserNameListener) getActivity();
        activity.onFinishUserDialog(mEditText.getText().toString());
        this.dismiss();
        return true;
    }
}