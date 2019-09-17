package com.sample.dialogSample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dialog.plus.ui.DialogPlus;
import com.dialog.plus.ui.MonthYearPickerDialog;
import com.dialog.plus.ui.MultiOptionsDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMultiOptionsDialogClicked(View view) {
        new MultiOptionsDialog("Multi Options Dialog Sample Title", getOptions()
                , new MultiOptionsDialog.ActionListener() {
            @Override
            public void onActionClicked(String clickedOption) {
                Toast.makeText(MainActivity.this, clickedOption, Toast.LENGTH_SHORT).show();
            }
        }).show(this.getSupportFragmentManager(), "dialog_plus");
    }

    private List<String> getOptions() {
        String[] titles = {"Option 1", "Option 2", "Option 3", "Option 4"};
        return new ArrayList<>(Arrays.asList(titles));
    }

    public void onClickedMessageCode(View view) {
        new DialogPlus("Message Dialog", "message dialog_plus sample\n Welcome Back")
                //@ColorRes int positiveBackground, @ColorRes int negativeColorRes, @ColorRes int headerBgColor
                .setBackgrounds(R.color.colorPrimary, R.color.colorAccent)
                .setMessageDialog("alright", new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onClickedConfirmCode(View view) {
        new DialogPlus("Code Dialog", "code dialog_plus sample with send enabled, resend enabled and counter 10 seconds")
                .setBackgroundColors(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimary)
                .setConfirmCodeDialog("12345", true, true, 60, Color.BLACK, null)
                .setDialogActionListener(new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onClickedValidation(View view) {
        new DialogPlus("Code Dialog", "code dialog_plus sample with send enabled and zero seconds counter.")
                .setBackgroundColors(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimary)
                .setHeaderBgDrawable(R.drawable.bg_header)
                .setConfirmCodeDialog("123", false, true, 0, Color.BLUE, null)
                .setDialogActionListener(new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onClickedConfirmation(View view) {
        new DialogPlus("Confirmation Dialog", "confirmation dialog_plus message content ...")
                .setBackgroundColors(R.color.colorPrimary, R.color.white, R.color.colorPrimary)
                .setConfirmationDialog("confirm", "cancel", new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onClickedConfirmation2(View view) {
        new DialogPlus("Confirmation Dialog option two interface", "Confirmation Dialog with separated action buttons ...")
                .setBackgroundColors(R.color.colorPrimary, R.color.white, R.color.colorPrimary)
                .setSecondaryTextColor(R.color.colorPrimary)
                .setConfirmationDialog("confirm", "cancel", true, new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onClickedErrorDialog(View view) {
        new DialogPlus("error dialog_plus content message")
                .setBackgroundColors(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimary)
                .setErrorDialog("Peace", new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onClickedSuccessDialog(View view) {
        new DialogPlus("Success message content..")
                .setBackgroundColors(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimary)
                .setSuccessDialog("Cool", new DialogListener())
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    public void onListDialogClicked(View view) {
        new DialogPlus()
                .setListDialog("list_dialog_test_title", getListItems(), new DialogPlus.DialogListListener() {
                    @Override
                    public void onItemClicked(String title, int index, DialogPlus dialogPlus) {
                        Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                        dialogPlus.dismiss();
                    }
                })
                .show(this.getSupportFragmentManager(), "dialog_plus");
    }

    private List<String> getListItems() {
        List<String> dialogItemDMS = new ArrayList<>();
        dialogItemDMS.add("title 4");
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 7"));
        dialogItemDMS.add(("title 9"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 54"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));
        dialogItemDMS.add(("title 4"));


        return dialogItemDMS;
    }

    public void onMonthYearDialogClicked(View view) {
        new MonthYearPickerDialog().getYearPicker(pickedYear ->
                Toast.makeText(this, "picked value: " + pickedYear, Toast.LENGTH_SHORT).show()).show(getSupportFragmentManager(), "dialog");
    }

    private class DialogListener extends DialogPlus.DialogActionListener {
        @Override
        public void onPositive(DialogPlus dialogPlus) {
            Toast.makeText(MainActivity.this, "onPositive", Toast.LENGTH_SHORT).show();
            dialogPlus.dismiss();
        }

        @Override
        public void onNegative(DialogPlus dialogPlus) {
            super.onNegative(dialogPlus);
            Toast.makeText(MainActivity.this, "onNegative", Toast.LENGTH_SHORT).show();
        }
    }
}

