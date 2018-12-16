package quanlisach;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import quanlisach.Tacgia;


/**
 *
 * @author HUNG
 */
public class Danhsachtacgia {
    private Tacgia[] dstg = new Tacgia[1];
    private int n ;

    public Danhsachtacgia() {
        n=0;
    }
    public Danhsachtacgia(Tacgia dstg[] , int n){
        this.n = n; 
        this.dstg = Arrays.copyOf(dstg, n);       
    }
    public Danhsachtacgia(Danhsachtacgia ds){
        this.n = ds.n;
        this.dstg = Arrays.copyOf(ds.dstg, n);
    }
    public void Nhap(){
        System.out.println("Nhap vao so luong tac gia can nhap :");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dstg = Arrays.copyOf(dstg, n);
        for(int i = 0 ; i < n  ; i++)
        {
            dstg[i] = new Tacgia();
            dstg[i].Nhap();
        }
    }
    public void Xuat(){
        System.out.printf("\n%-100s","______________________________________________________________________________________________");
        System.out.printf("\n|%-30s|%-30s|%-30s|","Ma tac gia","Ten tac gia","Ngay sinh");
        System.out.printf("\n|%-100s","---------------------------------------------------------------------------------------------");
        for(int i=0;i<n;i++)
        {
            dstg[i].Xuat();
           System.out.printf("\n|%-30s","---------------------------------------------------------------------------------------------");

        }
    }
    public void Them()
    {
        dstg = Arrays.copyOf(dstg,n+1);
        dstg[n] = new Tacgia();
        dstg[n].Nhap();
        n++;      
    }
    //Them nhieu tac gia
    public void Themk()
    {
   	 int k;
   	 System.out.println("\nMoi ban nhap vao so luong can them: ");
   	 Scanner in = new Scanner(System.in);
   	 k = in.nextInt();
   	 in.nextLine();
   	 for(int i=0 ; i<k;i++)
   	 {
   		 Them();
   	 }
    }
    public void Xoavt(int vitrixoa){
        for(int i = vitrixoa ; i < n - 1 ; i++)
        {
           dstg[i] = dstg[i+1];
        }
        n--;
    }
    //Xoa theo ma tac gia
    public void Xoatheoma()
    {
   	 String ma;
   	 Scanner in = new Scanner(System.in);
   	 System.out.println("\nMoi ban nhap vao ma tac gia de xoa: ");
   	 ma= in.nextLine();
   	 for(int i=0; i<n;i++)
   	 {
   		 if(dstg[i].getMatacgia().equals(ma));
   		 {
   			 Xoavt(i);
   		 }
   	 }
    }
    public void Suatheoma()
    {
    	String ma;
   	 	Scanner in = new Scanner(System.in);
   	 	System.out.println("\nMoi ban nhap vao ma giam gia can sua: ");
   	  	ma = in.nextLine();
        for(int i = 0 ; i < n ; i++)
        {
            if(dstg[i].getMatacgia().equals(ma))
            {
                int luachon;
                while(true)
                {
                    System.out.println("\n1.Sua ma tac gia ");
                    System.out.println("2.Sua ten tac gia ");
                    System.out.println("3.Sua ngay sinh ");
                    System.out.println("4.Thoat");
                    System.out.println("Moi ban nhap lua chon ");
                    luachon = in.nextInt();
                    in.nextLine();
                    if(luachon<1 || luachon>4)
   				    {
   					 System.out.println("\nMoi ban nhap dung lua chon. Cam on!!!");
   				    }
                    if(luachon == 1)
                    {
                        String mamoi;
                        System.out.println("Nhap ma tac gia moi ");
                        mamoi = in.nextLine();
                        dstg[i].setMatacgia(mamoi);
                    }
                    else if(luachon == 2)
                    {
                        String tentacgia;
                        System.out.println("Nhap vao ten tac gia moi ");
                        tentacgia = in.nextLine();
                        dstg[i].setTentacgia(tentacgia);
                    }
                    else if(luachon == 3)
                    {
                        String ngaysinh;
                        System.out.println("Nhap vao ngay sinh moi ");
                        ngaysinh = in.nextLine();
                        dstg[i].setNgaysinh(ngaysinh);
                    }
                    else if(luachon==4)
                    {
                    	System.out.println("\nBan da thoat sua thanh cong.");
                        break;
                    }
                    
                }
            }
        }
    }
    public void Timkiemtheoma(){
    	String ma;
    	boolean tim=false;
    	System.out.println("\nNhap vao ma can tim kiem: ");
    	Scanner in = new Scanner(System.in);
    	ma = in.nextLine();
    	System.out.println("\nDanh sach da tim kiem: ");
    	System.out.printf("\n%-100s","______________________________________________________________________________________________");
        System.out.printf("\n|%-30s|%-30s|%-30s|","Ma tac gia","Ten tac gia","Ngay sinh");
        System.out.printf("\n|%-100s","---------------------------------------------------------------------------------------------");
        for(int i = 0 ; i < n ; i++)
        {
            if(dstg[i].getMatacgia().equals(ma))
            {
            	tim=true;
                dstg[i].Xuat();
                System.out.printf("\n|%-30s","---------------------------------------------------------------------------------------------");
            }
        }
        if(tim==false)
        {
        	System.out.println("\nKhong tim thay ma ban vua nhap.");
        }
    }
     public void ghifile(String filename) throws FileNotFoundException, IOException
     {
         DataOutputStream outstream=new DataOutputStream(new FileOutputStream(filename));
         for(int i=0;i<n;i++)
         {
             dstg[i].ghifile(filename);
         }
         outstream.close();
     }
    public void docfile(String filename)
    {
        int i=0;
        int n=0;
        try{
        DataInputStream instream=new DataInputStream(new FileInputStream(filename));
        try{
            while(true){
                String matacgia=instream.readUTF();
                String tentacgia=instream.readUTF();
                String ngaysinh=instream.readUTF();
                dstg = Arrays.copyOf(dstg,n+1);
                dstg[i]=new Tacgia(matacgia,tentacgia,ngaysinh);
                i++;
                n++;
            }
        }catch(EOFException e){
        }finally{
            instream.close();
        }
        }catch(FileNotFoundException e)
        {
            System.out.println("IOEROR: "+filename+"Not Found:\n");
        }catch(IOException e)
        {
            System.out.println("IOEROR: "+e.getMessage()+"\n");
        }
    }
}
