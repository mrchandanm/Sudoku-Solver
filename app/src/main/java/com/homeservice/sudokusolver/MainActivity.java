package com.homeservice.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
EditText r0c0,r0c1,r0c2,r0c3,r0c4,r0c5,r0c6,r0c7,r0c8,
        r1c0,r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,
        r2c0,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,
        r3c0,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,
        r4c0,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,
        r5c0,r5c1,r5c2,r5c3,r5c4,r5c5,r5c6,r5c7,r5c8,
        r6c0,r6c1,r6c2,r6c3,r6c4,r6c5,r6c6,r6c7,r6c8,
        r7c0,r7c1,r7c2,r7c3,r7c4,r7c5,r7c6,r7c7,r7c8,
        r8c0,r8c1,r8c2,r8c3,r8c4,r8c5,r8c6,r8c7,r8c8;

AppCompatButton btnClear,btnSolve;
TextView txtv;
char[][] board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _init();

        btnSolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                board=new char[9][9];
               String temp;
               getArrayList();
               if(solveSudoku(board)){
                   setArraylist();
                   txtv.setText("Here is your Solved Sudoku !");
                   btnSolve.setText("Solved");
                   Toast.makeText(MainActivity.this, "Solved successfully", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_SHORT).show();
               }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });



    }

    private void setArraylist() {

        r0c0.setText(Character.toString(board[0][0]) );  r0c1.setText(Character.toString(board[0][1]));   r0c2.setText(Character.toString(board[0][2]));
        r0c3.setText(Character.toString(board[0][3]));  r0c4.setText(Character.toString(board[0][4]));   r0c5.setText(Character.toString(board[0][5]));
        r0c6.setText(Character.toString(board[0][6]));  r0c7.setText(Character.toString(board[0][7]));   r0c8.setText(Character.toString(board[0][8]));

        r1c0.setText(Character.toString(board[1][0]));  r1c1.setText(Character.toString(board[1][1]));   r1c2.setText(Character.toString(board[1][2]));
        r1c3.setText(Character.toString(board[1][3]));  r1c4.setText(Character.toString(board[1][4]));   r1c5.setText(Character.toString(board[1][5]));
        r1c6.setText(Character.toString(board[1][6]));  r1c7.setText(Character.toString(board[1][7]));   r1c8.setText(Character.toString(board[1][8]));

        r2c0.setText(Character.toString(board[2][0]));  r2c1.setText(Character.toString(board[2][1]));   r2c2.setText(Character.toString(board[2][2]));
        r2c3.setText(Character.toString(board[2][3]));  r2c4.setText(Character.toString(board[2][4]));   r2c5.setText(Character.toString(board[2][5]));
        r2c6.setText(Character.toString(board[2][6]));  r2c7.setText(Character.toString(board[2][7]));   r2c8.setText(Character.toString(board[2][8]));

        r3c0.setText(Character.toString(board[3][0]));  r3c1.setText(Character.toString(board[3][1]));   r3c2.setText(Character.toString(board[3][2]));
        r3c3.setText(Character.toString(board[3][3]));  r3c4.setText(Character.toString(board[3][4]));   r3c5.setText(Character.toString(board[3][5]));
        r3c6.setText(Character.toString(board[3][6]));  r3c7.setText(Character.toString(board[3][7]));   r3c8.setText(Character.toString(board[3][8]));

        r4c0.setText(Character.toString(board[4][0]));  r4c1.setText(Character.toString(board[4][1]));   r4c2.setText(Character.toString(board[4][2]));
        r4c3.setText(Character.toString(board[4][3]));  r4c4.setText(Character.toString(board[4][4]));   r4c5.setText(Character.toString(board[4][5]));
        r4c6.setText(Character.toString(board[4][6]));  r4c7.setText(Character.toString(board[4][7]));   r4c8.setText(Character.toString(board[4][8]));

        r5c0.setText(Character.toString(board[5][0]));  r5c1.setText(Character.toString(board[5][1]));   r5c2.setText(Character.toString(board[5][2]));
        r5c3.setText(Character.toString(board[5][3]));  r5c4.setText(Character.toString(board[5][4]));   r5c5.setText(Character.toString(board[5][5]));
        r5c6.setText(Character.toString(board[5][6]));  r5c7.setText(Character.toString(board[5][7]));   r5c8.setText(Character.toString(board[5][8]));

        r6c0.setText(Character.toString(board[6][0]));  r6c1.setText(Character.toString(board[6][1]));   r6c2.setText(Character.toString(board[6][2]));
        r6c3.setText(Character.toString(board[6][3]));  r6c4.setText(Character.toString(board[6][4]));   r6c5.setText(Character.toString(board[6][5]));
        r6c6.setText(Character.toString(board[6][6]));  r6c7.setText(Character.toString(board[6][7]));   r6c8.setText(Character.toString(board[6][8]));

        r7c0.setText(Character.toString(board[7][0]));  r7c1.setText(Character.toString(board[7][1]));   r7c2.setText(Character.toString(board[7][2]));
        r7c3.setText(Character.toString(board[7][3]));  r7c4.setText(Character.toString(board[7][4]));   r7c5.setText(Character.toString(board[7][5]));
        r7c6.setText(Character.toString(board[7][6]));  r7c7.setText(Character.toString(board[7][7]));   r7c8.setText(Character.toString(board[7][8]));

        r8c0.setText(Character.toString(board[8][0]));  r8c1.setText(Character.toString(board[8][1]));   r8c2.setText(Character.toString(board[8][2]));
        r8c3.setText(Character.toString(board[8][3]));  r8c4.setText(Character.toString(board[8][4]));   r8c5.setText(Character.toString(board[8][5]));
        r8c6.setText(Character.toString(board[8][6]));  r8c7.setText(Character.toString(board[8][7]));   r8c8.setText(Character.toString(board[8][8]));

    }

    public static boolean isValid( char[][] board,int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col]== c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '0') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solveSudoku(board))
                                return true;
                            else
                                board[i][j] = '0';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }


    private void getArrayList() {


        if(r0c0.getText().toString().isEmpty()) board[0][0]='0';  else board[0][0]=r0c0.getText().toString().charAt(0);
        if(r0c1.getText().toString().isEmpty()) board[0][1]='0';   else board[0][1]=r0c1.getText().toString().charAt(0);
        if(r0c2.getText().toString().isEmpty()) board[0][2]='0';  else board[0][2]=r0c2.getText().toString().charAt(0);
        if(r0c3.getText().toString().isEmpty()) board[0][3]='0';   else board[0][3]=r0c3.getText().toString().charAt(0);
        if(r0c4.getText().toString().isEmpty()) board[0][4]='0';  else board[0][4]=r0c4.getText().toString().charAt(0);
        if(r0c5.getText().toString().isEmpty()) board[0][5]='0';   else board[0][5]=r0c5.getText().toString().charAt(0);
        if(r0c6.getText().toString().isEmpty()) board[0][6]='0';  else board[0][6]=r0c6.getText().toString().charAt(0);
        if(r0c7.getText().toString().isEmpty()) board[0][7]='0';   else board[0][7]=r0c7.getText().toString().charAt(0);
        if(r0c8.getText().toString().isEmpty()) board[0][8]='0';  else board[0][8]=r0c8.getText().toString().charAt(0);


        if(r1c0.getText().toString().isEmpty()) board[1][0]='0';  else board[1][0]=r1c0.getText().toString().charAt(0);
        if(r1c1.getText().toString().isEmpty()) board[1][1]='0';   else board[1][1]=r1c1.getText().toString().charAt(0);
        if(r1c2.getText().toString().isEmpty()) board[1][2]='0';  else board[1][2]=r1c2.getText().toString().charAt(0);
        if(r1c3.getText().toString().isEmpty()) board[1][3]='0';   else board[1][3]=r1c3.getText().toString().charAt(0);
        if(r1c4.getText().toString().isEmpty()) board[1][4]='0';  else board[1][4]=r1c4.getText().toString().charAt(0);
        if(r1c5.getText().toString().isEmpty()) board[1][5]='0';   else board[1][5]=r1c5.getText().toString().charAt(0);
        if(r1c6.getText().toString().isEmpty()) board[1][6]='0';  else board[1][6]=r1c6.getText().toString().charAt(0);
        if(r1c7.getText().toString().isEmpty()) board[1][7]='0';   else board[1][7]=r1c7.getText().toString().charAt(0);
        if(r1c8.getText().toString().isEmpty()) board[1][8]='0';  else board[1][8]=r1c8.getText().toString().charAt(0);

        if(r2c0.getText().toString().isEmpty()) board[2][0]='0';  else board[2][0]=r2c0.getText().toString().charAt(0);
        if(r2c1.getText().toString().isEmpty()) board[2][1]='0';   else board[2][1]=r2c1.getText().toString().charAt(0);
        if(r2c2.getText().toString().isEmpty()) board[2][2]='0';  else board[2][2]=r2c2.getText().toString().charAt(0);
        if(r2c3.getText().toString().isEmpty()) board[2][3]='0';   else board[2][3]=r2c3.getText().toString().charAt(0);
        if(r2c4.getText().toString().isEmpty()) board[2][4]='0';  else board[2][4]=r2c4.getText().toString().charAt(0);
        if(r2c5.getText().toString().isEmpty()) board[2][5]='0';   else board[2][5]=r2c5.getText().toString().charAt(0);
        if(r2c6.getText().toString().isEmpty()) board[2][6]='0';  else board[2][6]=r2c6.getText().toString().charAt(0);
        if(r2c7.getText().toString().isEmpty()) board[2][7]='0';   else board[2][7]=r2c7.getText().toString().charAt(0);
        if(r2c8.getText().toString().isEmpty()) board[2][8]='0';  else board[2][8]=r2c8.getText().toString().charAt(0);

        if(r3c0.getText().toString().isEmpty()) board[3][0]='0';  else board[3][0]=r3c0.getText().toString().charAt(0);
        if(r3c1.getText().toString().isEmpty()) board[3][1]='0';   else board[3][1]=r3c1.getText().toString().charAt(0);
        if(r3c2.getText().toString().isEmpty()) board[3][2]='0';  else board[3][2]=r3c2.getText().toString().charAt(0);
        if(r3c3.getText().toString().isEmpty()) board[3][3]='0';   else board[3][3]=r3c3.getText().toString().charAt(0);
        if(r3c4.getText().toString().isEmpty()) board[3][4]='0';  else board[3][4]=r3c4.getText().toString().charAt(0);
        if(r3c5.getText().toString().isEmpty()) board[3][5]='0';   else board[3][5]=r3c5.getText().toString().charAt(0);
        if(r3c6.getText().toString().isEmpty()) board[3][6]='0';  else board[3][6]=r3c6.getText().toString().charAt(0);
        if(r3c7.getText().toString().isEmpty()) board[3][7]='0';   else board[3][7]=r3c7.getText().toString().charAt(0);
        if(r3c8.getText().toString().isEmpty()) board[3][8]='0';  else board[3][8]=r3c8.getText().toString().charAt(0);

        if(r4c0.getText().toString().isEmpty()) board[4][0]='0';  else board[4][0]=r4c0.getText().toString().charAt(0);
        if(r4c1.getText().toString().isEmpty()) board[4][1]='0';   else board[4][1]=r4c1.getText().toString().charAt(0);
        if(r4c2.getText().toString().isEmpty()) board[4][2]='0';  else board[4][2]=r4c2.getText().toString().charAt(0);
        if(r4c3.getText().toString().isEmpty()) board[4][3]='0';   else board[4][3]=r4c3.getText().toString().charAt(0);
        if(r4c4.getText().toString().isEmpty()) board[4][4]='0';  else board[4][4]=r4c4.getText().toString().charAt(0);
        if(r4c5.getText().toString().isEmpty()) board[4][5]='0';   else board[4][5]=r4c5.getText().toString().charAt(0);
        if(r4c6.getText().toString().isEmpty()) board[4][6]='0';  else board[4][6]=r4c6.getText().toString().charAt(0);
        if(r4c7.getText().toString().isEmpty()) board[4][7]='0';   else board[4][7]=r4c7.getText().toString().charAt(0);
        if(r4c8.getText().toString().isEmpty()) board[4][8]='0';  else board[4][8]=r4c8.getText().toString().charAt(0);

        if(r5c0.getText().toString().isEmpty()) board[5][0]='0';  else board[5][0]=r5c0.getText().toString().charAt(0);
        if(r5c1.getText().toString().isEmpty()) board[5][1]='0';   else board[5][1]=r5c1.getText().toString().charAt(0);
        if(r5c2.getText().toString().isEmpty()) board[5][2]='0';  else board[5][2]=r5c2.getText().toString().charAt(0);
        if(r5c3.getText().toString().isEmpty()) board[5][3]='0';   else board[5][3]=r5c3.getText().toString().charAt(0);
        if(r5c4.getText().toString().isEmpty()) board[5][4]='0';  else board[5][4]=r5c4.getText().toString().charAt(0);
        if(r5c5.getText().toString().isEmpty()) board[5][5]='0';   else board[5][5]=r5c5.getText().toString().charAt(0);
        if(r5c6.getText().toString().isEmpty()) board[5][6]='0';  else board[5][6]=r5c6.getText().toString().charAt(0);
        if(r5c7.getText().toString().isEmpty()) board[5][7]='0';   else board[5][7]=r5c7.getText().toString().charAt(0);
        if(r5c8.getText().toString().isEmpty()) board[5][8]='0';  else board[5][8]=r5c8.getText().toString().charAt(0);

        if(r6c0.getText().toString().isEmpty()) board[6][0]='0';  else board[6][0]=r6c0.getText().toString().charAt(0);
        if(r6c1.getText().toString().isEmpty()) board[6][1]='0';   else board[6][1]=r6c1.getText().toString().charAt(0);
        if(r6c2.getText().toString().isEmpty()) board[6][2]='0';  else board[6][2]=r6c2.getText().toString().charAt(0);
        if(r6c3.getText().toString().isEmpty()) board[6][3]='0';   else board[6][3]=r6c3.getText().toString().charAt(0);
        if(r6c4.getText().toString().isEmpty()) board[6][4]='0';  else board[6][4]=r6c4.getText().toString().charAt(0);
        if(r6c5.getText().toString().isEmpty()) board[6][5]='0';   else board[6][5]=r6c5.getText().toString().charAt(0);
        if(r6c6.getText().toString().isEmpty()) board[6][6]='0';  else board[6][6]=r6c6.getText().toString().charAt(0);
        if(r6c7.getText().toString().isEmpty()) board[6][7]='0';   else board[6][7]=r6c7.getText().toString().charAt(0);
        if(r6c8.getText().toString().isEmpty()) board[6][8]='0';  else board[6][8]=r6c8.getText().toString().charAt(0);

        if(r7c0.getText().toString().isEmpty()) board[7][0]='0';  else board[7][0]=r7c0.getText().toString().charAt(0);
        if(r7c1.getText().toString().isEmpty()) board[7][1]='0';   else board[7][1]=r7c1.getText().toString().charAt(0);
        if(r7c2.getText().toString().isEmpty()) board[7][2]='0';  else board[7][2]=r7c2.getText().toString().charAt(0);
        if(r7c3.getText().toString().isEmpty()) board[7][3]='0';   else board[7][3]=r7c3.getText().toString().charAt(0);
        if(r7c4.getText().toString().isEmpty()) board[7][4]='0';  else board[7][4]=r7c4.getText().toString().charAt(0);
        if(r7c5.getText().toString().isEmpty()) board[7][5]='0';   else board[7][5]=r7c5.getText().toString().charAt(0);
        if(r7c6.getText().toString().isEmpty()) board[7][6]='0';  else board[7][6]=r7c6.getText().toString().charAt(0);
        if(r7c7.getText().toString().isEmpty()) board[7][7]='0';   else board[7][7]=r7c7.getText().toString().charAt(0);
        if(r7c8.getText().toString().isEmpty()) board[7][8]='0';  else board[7][8]=r7c8.getText().toString().charAt(0);

        if(r8c0.getText().toString().isEmpty()) board[8][0]='0';  else board[8][0]=r8c0.getText().toString().charAt(0);
        if(r8c1.getText().toString().isEmpty()) board[8][1]='0';   else board[8][1]=r8c1.getText().toString().charAt(0);
        if(r8c2.getText().toString().isEmpty()) board[8][2]='0';  else board[8][2]=r8c2.getText().toString().charAt(0);
        if(r8c3.getText().toString().isEmpty()) board[8][3]='0';   else board[8][3]=r8c3.getText().toString().charAt(0);
        if(r8c4.getText().toString().isEmpty()) board[8][4]='0';  else board[8][4]=r8c4.getText().toString().charAt(0);
        if(r8c5.getText().toString().isEmpty()) board[8][5]='0';   else board[8][5]=r8c5.getText().toString().charAt(0);
        if(r8c6.getText().toString().isEmpty()) board[8][6]='0';  else board[8][6]=r8c6.getText().toString().charAt(0);
        if(r8c7.getText().toString().isEmpty()) board[8][7]='0';   else board[8][7]=r8c7.getText().toString().charAt(0);
        if(r8c8.getText().toString().isEmpty()) board[8][8]='0';  else board[8][8]=r8c8.getText().toString().charAt(0);

    }

    private void _init(){
        btnSolve=findViewById(R.id.btnsolve);
        btnClear=findViewById(R.id.btnclear);
        txtv=findViewById(R.id.txtv);

    r0c0=findViewById(R.id.r0c0);   r0c1=findViewById(R.id.r0c1);  r0c2=findViewById(R.id.r0c2);
    r0c3=findViewById(R.id.r0c3);   r0c4=findViewById(R.id.r0c4);  r0c5=findViewById(R.id.r0c5);
    r0c6=findViewById(R.id.r0c6);   r0c7=findViewById(R.id.r0c7);  r0c8=findViewById(R.id.r0c8);

    r1c0=findViewById(R.id.r1c0);   r1c1=findViewById(R.id.r1c1);  r1c2=findViewById(R.id.r1c2);
    r1c3=findViewById(R.id.r1c3);   r1c4=findViewById(R.id.r1c4);  r1c5=findViewById(R.id.r1c5);
    r1c6=findViewById(R.id.r1c6);   r1c7=findViewById(R.id.r1c7);  r1c8=findViewById(R.id.r1c8);

    r2c0=findViewById(R.id.r2c0);   r2c1=findViewById(R.id.r2c1);  r2c2=findViewById(R.id.r2c2);
    r2c3=findViewById(R.id.r2c3);   r2c4=findViewById(R.id.r2c4);  r2c5=findViewById(R.id.r2c5);
    r2c6=findViewById(R.id.r2c6);   r2c7=findViewById(R.id.r2c7);  r2c8=findViewById(R.id.r2c8);

    r3c0=findViewById(R.id.r3c0);   r3c1=findViewById(R.id.r3c1);  r3c2=findViewById(R.id.r3c2);
    r3c3=findViewById(R.id.r3c3);   r3c4=findViewById(R.id.r3c4);  r3c5=findViewById(R.id.r3c5);
    r3c6=findViewById(R.id.r3c6);   r3c7=findViewById(R.id.r3c7);  r3c8=findViewById(R.id.r3c8);

    r4c0=findViewById(R.id.r4c0);   r4c1=findViewById(R.id.r4c1);  r4c2=findViewById(R.id.r4c2);
    r4c3=findViewById(R.id.r4c3);   r4c4=findViewById(R.id.r4c4);  r4c5=findViewById(R.id.r4c5);
    r4c6=findViewById(R.id.r4c6);   r4c7=findViewById(R.id.r4c7);  r4c8=findViewById(R.id.r4c8);

    r5c0=findViewById(R.id.r5c0);   r5c1=findViewById(R.id.r5c1);  r5c2=findViewById(R.id.r5c2);
    r5c3=findViewById(R.id.r5c3);   r5c4=findViewById(R.id.r5c4);  r5c5=findViewById(R.id.r5c5);
    r5c6=findViewById(R.id.r5c6);   r5c7=findViewById(R.id.r5c7);  r5c8=findViewById(R.id.r5c8);

    r6c0=findViewById(R.id.r6c0);   r6c1=findViewById(R.id.r6c1);  r6c2=findViewById(R.id.r6c2);
    r6c3=findViewById(R.id.r6c3);   r6c4=findViewById(R.id.r6c4);  r6c5=findViewById(R.id.r6c5);
    r6c6=findViewById(R.id.r6c6);   r6c7=findViewById(R.id.r6c7);  r6c8=findViewById(R.id.r6c8);

    r7c0=findViewById(R.id.r7c0);   r7c1=findViewById(R.id.r7c1);  r7c2=findViewById(R.id.r7c2);
    r7c3=findViewById(R.id.r7c3);   r7c4=findViewById(R.id.r7c4);  r7c5=findViewById(R.id.r7c5);
    r7c6=findViewById(R.id.r7c6);   r7c7=findViewById(R.id.r7c7);  r7c8=findViewById(R.id.r7c8);

    r8c0=findViewById(R.id.r8c0);   r8c1=findViewById(R.id.r8c1);  r8c2=findViewById(R.id.r8c2);
    r8c3=findViewById(R.id.r8c3);   r8c4=findViewById(R.id.r8c4);  r8c5=findViewById(R.id.r8c5);
    r8c6=findViewById(R.id.r8c6);   r8c7=findViewById(R.id.r8c7);  r8c8=findViewById(R.id.r8c8);
}
}