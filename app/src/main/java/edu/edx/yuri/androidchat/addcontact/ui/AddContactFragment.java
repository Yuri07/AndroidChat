package edu.edx.yuri.androidchat.addcontact.ui;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.edx.yuri.androidchat.R;
import edu.edx.yuri.androidchat.addcontact.AddContactPresenter;
import edu.edx.yuri.androidchat.addcontact.AddContactPresenterImpl;

/**
 * Created by yuri_ on 10/11/2017.
 */

public class AddContactFragment extends DialogFragment implements AddContactView, DialogInterface.OnShowListener {

    @BindView(R.id.editTxtEmail)
    EditText inputEmail;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private AddContactPresenter addContactPresenter;

    public AddContactFragment() {
        addContactPresenter = new AddContactPresenterImpl(this);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder =  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.addcontact_message_title)
                .setPositiveButton(R.string.addcontact_message_add,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                .setNegativeButton(R.string.addcontact_message_cancel,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {}
                        });

        LayoutInflater i = getActivity().getLayoutInflater();
        View view = i.inflate(R.layout.fragment_add_contact_dialog,null);
        ButterKnife.bind(this, view);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(this);

        return dialog;
    }

    @Override
    public void onShow(DialogInterface dialogInterface) {
        final AlertDialog dialog = (AlertDialog) getDialog();
        if (dialog != null) {

            Button positiveButton = dialog.getButton(Dialog.BUTTON_POSITIVE);
            Button negativeButton = dialog.getButton(Dialog.BUTTON_NEGATIVE);

            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addContactPresenter.addContact(inputEmail.getText().toString());
                }
            });

            negativeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dismiss();
                }
            });
        }
        addContactPresenter.onShow();
    }

    @Override
    public void showInput() {
        inputEmail.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideInput() {
        inputEmail.setVisibility(View.GONE);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void contactAdded() {
        Toast.makeText(getActivity(), R.string.addcontact_message_contactadded, Toast.LENGTH_SHORT).show();
        dismiss();
    }

    @Override
    public void contactNotAdded() {
        inputEmail.setText("");
        inputEmail.setError(getString(R.string.addcontact_error_message));
    }
}
