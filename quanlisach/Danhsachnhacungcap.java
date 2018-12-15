/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author HUNG
 */
public class Danhsachnhacungcap {
    private int n ;
    private Nhacungcap[] dsncc = new Nhacungcap[1];
    public Danhsachnhacungcap(){
    }
    public Danhsachnhacungcap(Nhacungcap[] a,int n){
        this.n = n;
        this.dsncc = Arrays.copyOf(a, n);
    }
    public Danhsachnhacungcap(Danhsachnhacungcap ds){
        this.n = ds.n;
        this.dsncc = Arrays.copyOf(ds.dsncc,n);
    }
    public void Nhapdanhsachnhacungcap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap vao so luong nha cung cap :");
        this.n = in.nextInt();
        dsncc = Arrays.copyOf(dsncc,n);
        for(int i = 0 ; i < n ; i++)
        {
            dsncc[i] = new Nhacungcap();
            dsncc[i].Nhap();
        }
        
    }
    public void Xuatdanhsachnhacungcap(){
    	System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
    	System.out.printf("\n|%-15s|%-15s|%-10s|%-10s|","manhacungcap","tennhacungcap","diachi","dienthoai");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
         for(int i = 0 ; i < n ; i++)
        {
            dsncc[i].Xuat();
            System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
            
        }
    }
    public void Xoanhacungcap(int vitrixoa){
        for(int i = vitrixoa ; i < n -1 ; i++)
        {
            dsncc[i] = dsncc[i+1];
        }
        dsncc = Arrays.copyOf(dsncc,n-1);
        n--;
    }
    public void Xoanhacungcaptheoma(String ma){
        for(int i = 0 ; i < n ; i++)
        {
            if(dsncc[i].getManhacungcap().equals(ma))
            {
                Xoanhacungcap(i);
            }
        }
    }
    public void Themnhacungcap(){
        dsncc = Arrays.copyOf(dsncc,n+1);
        dsncc[n] = new Nhacungcap();
        dsncc[n].Nhap();
        n++;
    }
    public void Themnhacungcap(Nhacungcap ncc)
    {
        dsncc = Arrays.copyOf(dsncc,n+1);
        dsncc[n] = new Nhacungcap(ncc);
        n++;
    }
   public void Timkiemnhacungcap(String ma)
   {
       for(int i = 0 ; i < n ; i++)
       {
           if(dsncc[i].getManhacungcap().equals(ma))
           {
               System.out.println(dsncc[i].toString());
           }
       }
   }
   public void Ghifile(String filename) throws FileNotFoundException, IOException{
       DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
       for(int i = 0 ; i < n ; i++)
       {
           dsncc[i].Ghifile(filename);
       }
       outstream.close();
   }
   public void Docfile(String filename) throws IOException
   {
       int i = 0; 
       n = 0;
        try{
            DataInputStream instream = new DataInputStream(new FileInputStream(filename));
            try{
                while(true){
                    String id = instream.readUTF();
                    String name = instream.readUTF();
                    String address = instream.readUTF();
                    String phone = instream.readUTF();
                    dsncc = Arrays.copyOf(dsncc,n+1);
                    dsncc[i] = new Nhacungcap(id,name,address,phone);
                    i++;
                    n++;
                }
            }
            catch(EOFException e){
                
            }
            finally{
                instream.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("IOERROR "+filename +"not found");
        }
        catch(IOException a){
            System.out.println("IOERROR "+a.getMessage()+"\n");
        }
    }
    
}
