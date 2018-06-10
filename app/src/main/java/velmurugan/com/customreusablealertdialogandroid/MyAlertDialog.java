package velmurugan.com.customreusablealertdialogandroid;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAlertDialog extends AlertDialog {

    private TextView tvTitle,tvDesc;
    private Button btnLeft,btnRight,btnMiddle;
    private LinearLayout layoutTwoButtons,layoutOneButton;
    private Boolean isInfoMode = false;
    private ImageView alertIcon;
    private DialogActionListener dialogActionListener;

    protected MyAlertDialog(Context context) {
        super(context);
        initialize();
    }

    private void initialize() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.my_alert_layout,null);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        tvTitle = view.findViewById(R.id.tv_title);
        tvDesc = view.findViewById(R.id.tv_desc);
        alertIcon = view.findViewById(R.id.alert_icon);

        btnLeft = view.findViewById(R.id.btn_left);
        btnRight = view.findViewById(R.id.btn_right);
        btnMiddle = view.findViewById(R.id.btn_middle);

        layoutOneButton = view.findViewById(R.id.layout_one_button);
        layoutTwoButtons = view.findViewById(R.id.layout_two_button);

        setClickListener(btnLeft,btnRight,btnMiddle);
        setView(view);
    }

    private void setClickListener(View... views){
        for (View view: views){
            view.setOnClickListener(mOnClickListener);
        }
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialogActionListener.onAction(v);
        }
    };

    public void setOnActionListener(DialogActionListener dialogActionListener){
        this.dialogActionListener = dialogActionListener;
    }

    public void setAlertTitle(String title) {
        if(title != null){
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
        }
    }

    public void setAlertDesciption(String desciption) {
        tvDesc.setVisibility(View.VISIBLE);
        tvDesc.setText(desciption);
    }

    public void setRightButtonText(String text) {
        layoutTwoButtons.setVisibility(View.VISIBLE);
        layoutOneButton.setVisibility(View.GONE);
        btnRight.setVisibility(View.VISIBLE);
        btnRight.setText(text);
    }

    public void setLeftButtonText(String text) {
        layoutTwoButtons.setVisibility(View.VISIBLE);
        layoutOneButton.setVisibility(View.GONE);
        btnLeft.setVisibility(View.VISIBLE);
        btnLeft.setText(text);
    }

    public void setMiddleButtonText(String text) {
        layoutTwoButtons.setVisibility(View.GONE);
        layoutOneButton.setVisibility(View.VISIBLE);
        btnMiddle.setText(text);
    }

    public void setAlertIcon(Drawable drawable) {
        alertIcon.setVisibility(View.VISIBLE);
        alertIcon.setBackground(drawable);
    }

    public interface DialogActionListener{
        void onAction(View viewId);
    }

}
