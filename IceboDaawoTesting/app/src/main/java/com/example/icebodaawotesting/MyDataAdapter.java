package com.example.icebodaawotesting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyViewHolder> {

    Context c;
    List<Student> list;
    public MyDataAdapter(MainActivity mainActivity, List<Student> studentList) {

        c = mainActivity;
        list = studentList;

    }

    @NonNull
    @Override
    public MyDataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.row_design,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyDataAdapter.MyViewHolder holder, int position) {

        final Student student = list.get(position);
        holder.rroll.setText(student.getRollNumber());
        holder.rname.setText(student.getName());
        holder.rmail.setText(student.getMailID());
        holder.rmobile.setText(student.getPhoneNumber());

        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MainActivity.database.myDAO().delete(student);
                MainActivity.viewModel.delete(student);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView rname,rroll,rmail,rmobile;
        ImageView del,edit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rname = itemView.findViewById(R.id.readname);
            rroll = itemView.findViewById(R.id.readroll);
            rmail = itemView.findViewById(R.id.readmailid);
            rmobile = itemView.findViewById(R.id.readphno);
            del = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /* Access Data from TextViews */
                    final String name = rname.getText().toString();
                    final String rollno = rroll.getText().toString();
                    final String mail = rmail.getText().toString();
                    final String mob = rmobile.getText().toString();

                    ViewGroup viewGroup = view.findViewById(android.R.id.content);
                    View v = LayoutInflater.from(c).inflate(R.layout.updatedata,viewGroup,false);

                    final EditText uname = v.findViewById(R.id.updatename);
                    final EditText uroll = v.findViewById(R.id.updateroll);
                    final EditText umail = v.findViewById(R.id.updatemail);
                    final EditText uphno = v.findViewById(R.id.updatephno);
                    Button update = v.findViewById(R.id.updatedata);
                    Button cancel = v.findViewById(R.id.canceldata);


                    final BottomSheetDialog dialog = new BottomSheetDialog(c);
                    dialog.setContentView(v);
                    dialog.setCancelable(false);

                    uroll.setText(rollno);
                    uname.setText(name);
                    uphno.setText(mob);
                    umail.setText(mail);

                    update.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            Student student = new Student();
                            student.setMailID(umail.getText().toString());
                            student.setName(uname.getText().toString());
                            student.setRollNumber(uroll.getText().toString());
                            student.setPhoneNumber(uphno.getText().toString());
                            MainActivity.viewModel.update(student);
                            Toast.makeText(c, "Data Updated Successfully", Toast.LENGTH_LONG).show();
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
