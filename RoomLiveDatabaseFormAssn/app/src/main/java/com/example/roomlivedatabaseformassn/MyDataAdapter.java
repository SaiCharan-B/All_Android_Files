package com.example.roomlivedatabaseformassn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyDataViewHolder> {

    Context ct;
    List<Student> list;
    public MyDataAdapter(MainActivity mainActivity, List<Student> studentList) {
        ct = mainActivity;
        list = studentList;
    }

    @NonNull
    @Override
    public MyDataAdapter.MyDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.row_design,parent,false);
        return new MyDataViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.MyDataViewHolder holder, int position) {

        final Student student = list.get(position);

        holder.rname.setText(student.getName());
        holder.rmail.setText(student.getMailid());
        holder.rmobile.setText(student.getPhno());
        holder.raddress.setText(student.getAddress());
        holder.rdepart.setText(student.getDepartment());
        holder.rgender.setText(student.getGender());
        holder.rlang.setText(student.getLanguages());

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.database.myDao().delete(student);
                MainActivity.viewModel.delete(student);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyDataViewHolder extends RecyclerView.ViewHolder {

        TextView rname,rmail,rmobile,raddress,rdepart,rgender,rlang;
        ImageView delete,edit;
        public MyDataViewHolder(@NonNull View itemView) {
            super(itemView);
            rname = itemView.findViewById(R.id.readname);
            rmail = itemView.findViewById(R.id.readmailid);
            rmobile = itemView.findViewById(R.id.readmobile);
            raddress = itemView.findViewById(R.id.readaddress);
            rdepart = itemView.findViewById(R.id.readdepartment);
            rgender = itemView.findViewById(R.id.readgender);
            rlang = itemView.findViewById(R.id.readlanguage);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*Access Data fro TextViews*/

                    final String name = rname.getText().toString();
                    final String mail = rmail.getText().toString();
                    final String mobile = rmobile.getText().toString();
                    String add = raddress.getText().toString();
                    String dept = rdepart.getText().toString();
                    String gender = rgender.getText().toString();
                    String lang = rlang.getText().toString();

                    ViewGroup viewGroup = view.findViewById(android.R.id.content);
                    View v = LayoutInflater.from(ct).inflate(R.layout.updatedata,viewGroup,false);

                    final EditText uname = v.findViewById(R.id.updatename);
                    final EditText umail = v.findViewById(R.id.updatemailID);
                    final EditText umobile = v.findViewById(R.id.updatemobilenumber);
                    final EditText uaddress = v.findViewById(R.id.updateaddress);
                    final EditText udept = v.findViewById(R.id.updatedepartment);
                    final EditText ugender = v.findViewById(R.id.updategender);
                    final EditText ulang = v.findViewById(R.id.updatelanguage);
                    Button update = v.findViewById(R.id.updatedata);
                    Button cancel = v.findViewById(R.id.canceldata);

                    final BottomSheetDialog dialog = new BottomSheetDialog(ct);
                    dialog.setContentView(v);
                    dialog.setCancelable(false);


                    uname.setText(name);
                    umobile.setText(mobile);
                    umail.setText(mail);
                    uaddress.setText(add);
                    udept.setText(dept);
                    ugender.setText(gender);
                    ulang.setText(lang);

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Student student=new Student();
                            student.setMailid(umail.getText().toString());
                            student.setName(uname.getText().toString());
                            student.setPhno(umobile.getText().toString());
                            student.setAddress(uaddress.getText().toString());
                            student.setDepartment(udept.getText().toString());
                            student.setGender(ugender.getText().toString());
                            student.setLanguages(ulang.getText().toString());
                            MainActivity.viewModel.update(student);
                            Toast.makeText(ct, "Data Update Sucessfully", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    cancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });
                    dialog.show();
                }
            });

        }
    }
}