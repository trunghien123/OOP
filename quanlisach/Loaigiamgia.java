/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Loaigiamgia {
  private float sophantram;
    public Loaigiamgia(){}
    public Loaigiamgia(float sophantram)
    {
        this.sophantram=sophantram;
    }
    public Loaigiamgia(Loaigiamgia lgg)
    {
        sophantram=lgg.sophantram;
    }
    public void Nhap()
    {
        Scanner nhap=new Scanner(System.in);
        System.out.println("\nNhap vao so phan tram giam gia: ");
            sophantram=nhap.nextFloat();
    }
    public void Xuat()
    {
    	System.out.printf("\n|%-20s|",sophantram);
    }
    public float getSophantram()
    {
        return sophantram;
    }
    public void setSophantram(float sophantram)
    {
        this.sophantram=sophantram;
    }
    public void Ghifile(String filename)
    {
    	try {
    		DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename,true));
    		outstream.writeFloat(this.sophantram);
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error "+e.getMessage()+"\n");
    	}
    }
}
