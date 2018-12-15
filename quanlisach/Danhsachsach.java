/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlisach;

/**
 *
 * @author HUNG
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

public class Danhsachsach {
 private int n;
 private Sach[] dss = new Sach[1];
 public Danhsachsach()
 {}
 public Danhsachsach(int n, Sach[] dss)
 {
	 this.n=n;
	 this.dss = Arrays.copyOf(dss, n);
 }
 public Danhsachsach(Danhsachsach dss)
 {
	 this.n= dss.n;
	 this.dss = Arrays.copyOf(dss.dss, n);
 }
 public void Nhap() throws IOException
 {
	 Scanner Nhap= new Scanner(System.in);
	 System.out.println("Nhap vao so luong sach: ");
	  	n=Nhap.nextInt();
	  	dss= Arrays.copyOf(dss, n);
	  	int luachon;
	  	for(int i=0;i<n;i++)
	  	{
	  		System.out.println("1 Nhap vao sach giao khoa");
	  		System.out.println("2 Nhap vao truyen");
	  		System.out.println("3 Nhap de thoat");
	  		System.out.println("Nhap vao lua chon: ");
	  		luachon=Nhap.nextInt();
                        Nhap.nextLine();
	  		if(luachon==1)
	  		{
	  			dss[i] = new Sachgiaokhoa();
	  			dss[i].Nhap();
	  		}
	  		else if(luachon==2)
	  		{
	  			dss[i] = new Truyen();
	  			dss[i].Nhap();
	  		}
	  		else if(luachon==3) break;
	  		else
	  		{
	  			System.out.println("Ban da Nhap sai. Xin Nhap lai lua chon");
	  			i=i-1;
	  		}
	  	}
 }
 public void Xuat()
	{
		System.out.printf("\n%-100s","______________________________________________________________________________________________________________________________________________________");
		System.out.printf("\n|%-10s|%-30s|%-10s|%-15s|%-15s|%-10s|%-10s|%-10s|%-30s|","Masach","Tensach","Matacgia","Manhasanxuat","Maloaisach","Magiamgia","Soluong","Dongia","Kethua");
		System.out.printf("\n|%-100s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i=0;i<n;i++)
		{
			dss[i].Xuat();
			System.out.printf("\n|%-10s","-----------------------------------------------------------------------------------------------------------------------------------------------------");
		}
	}
        
       
 public void Them() throws IOException
 {
	 Scanner sc=new Scanner(System.in);
	 int luachon;
	 while (true)
	 {
		 System.out.println("1 Nhap vao sach giao khoa");
		 System.out.println("2 Nhap vao truyen");
		 System.out.println("3 Nhap de thoat");
		 System.out.println("Nhap vao lua chon");
		 luachon = sc.nextInt();
		 if(luachon== 1)
		 {
			 dss = Arrays.copyOf(dss, n+1);
			 dss[n] = new Sachgiaokhoa();
			 dss[n].Nhap();
			 n++;
			 break;
		 }
		 else if(luachon == 2)
		 {
			 dss= Arrays.copyOf(dss, n+1);
			 dss[n] = new Truyen();
			 dss[n].Nhap();
			 n++;
			 break;
		 }
		 else { break;}
	 }
 }
 public void Themk(int k) throws IOException
 {
	 dss=Arrays.copyOf(dss, n+k);
	 for(int i=n;i< n+k;i++)
	 {
		 Them();
	 }
 }
 public void xoavt(int vitrixoa)
 {
	 for(int i=vitrixoa ; i<n-1 ;i++)
	 {
		 dss[i] = dss[i+1];
	 }
	 dss = Arrays.copyOf(dss, n-1);
	 n--;
 }
 public void Xoatheoma(String Masach)
 {
	 for(int i=0 ;i<n; i++)
	 {
		 if(dss[i].getMasach().equals(Masach))
		 {
			 xoavt(i);
			 break;
		 }
	 }
 }
 public int Timkiemtheoma(String Masach)
 {
	 int a = 0;
	 for(int i=0 ;i<n; i++)
	 {
		 if(dss[i].getMasach().equals(Masach))
		 {
			 a=i;
			 break;
		 }
	 }
	 return a;
 }
 //??????????????????????????????
 public void tim_kiem_theo_masach(String Masach)
 {
	 for(int i=0;i<n;i++)
	 {
		 if(dss[i].getMasach().equals(Masach))
		 {
			 dss[i].toString();
		 }
	 }
 }
 public void tim_kiem_theo_tensach(String Tensach)
 {
	 for(int i=0;i<n;i++)
	 {
		 if(dss[i].getTensach().equalsIgnoreCase(Tensach))
		 {
			 dss[i].toString();
		 }
	 }
 }
 //???????????????????????????/^^^^^^^^^^^^^^.^^^
 public void swap1(Sach a,Sach b)
 {
     Sachgiaokhoa tam = new Sachgiaokhoa((Sachgiaokhoa)a);
     a = (Sachgiaokhoa)b;
     b = tam;
     
 }
 public void swap2(Sach a,Sach b)
 {
     Truyen tam = new Truyen((Truyen)a);
     a = (Truyen)b;
     b = tam;
 }
 public void swap3(Sach a,Sach b)
 {
    Sachgiaokhoa tam1 = new Sachgiaokhoa((Sachgiaokhoa)a);
     Truyen tam2 = new Truyen((Truyen)b);
     a = tam2;
     b = tam1;
    
    
 }

 public void sort_tensach()
 {
	 for(int i=0;i<n-1;i++)
	 {
		 for(int j=i+1;j<n;j++)
		 {
			 if(dss[i].getTensach().compareTo(dss[j].getTensach())>0)
			 {
				if(dss[i]instanceof Sachgiaokhoa && dss[j] instanceof Sachgiaokhoa)
                                {
                                    swap1(dss[i],dss[j]);
                                }
                                else if(dss[i]instanceof Truyen && dss[j] instanceof Truyen)
                                {
                                    swap2(dss[i],dss[j]);
                                }
                                else if(dss[i]instanceof Sachgiaokhoa && dss[j] instanceof Truyen)
                                {
                                    swap3(dss[i],dss[j]);
                                }
                                else
                                {
                                    swap3(dss[j],dss[i]);
                                }
			 }
		 }
	 }
 }
 public int thong_ke_theo_tensach(String Tensach)
 {
	 int dem=0;
	 for(int i=0;i<n;i++)
	 {
		 if(dss[i].getTensach().equalsIgnoreCase(Tensach))
		 {
			 dem++;
		 }
	 }
	 return dem;
 }
 public void Ghifile(String filename) throws FileNotFoundException, IOException
 {
     DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
     for(int i = 0 ; i < n ; i++)
     {
         if(dss[i] instanceof Sachgiaokhoa)
         {
             outstream.writeUTF("SGK");
             outstream.writeUTF(dss[i].getMasach());
            outstream.writeUTF(dss[i].getTensach());
            outstream.writeUTF(dss[i].getMatacgia());
             outstream.writeUTF(dss[i].getManhasanxuat());
             outstream.writeUTF(dss[i].getMaloai());
            outstream.writeUTF(dss[i].getMagiamgia());
            outstream.writeInt(dss[i].getDongia());
            outstream.writeInt(dss[i].getSoluong());
            Sachgiaokhoa a = new Sachgiaokhoa();
            a = (Sachgiaokhoa)dss[i];
            outstream.writeUTF(a.getMon());
            outstream.writeUTF(a.getLop());
             
         }
         else
         {
             outstream.writeUTF("T");
              outstream.writeUTF(dss[i].getMasach());
            outstream.writeUTF(dss[i].getTensach());
            outstream.writeUTF(dss[i].getMatacgia());
             outstream.writeUTF(dss[i].getManhasanxuat());
             outstream.writeUTF(dss[i].getMaloai());
            outstream.writeUTF(dss[i].getMagiamgia());
            outstream.writeInt(dss[i].getDongia());
            outstream.writeInt(dss[i].getSoluong());
            Truyen a = new Truyen();
            a = (Truyen)dss[i];
            outstream.writeInt(a.getLuatuoi());
            outstream.writeUTF(a.getChude());
             
           }
     
        }
     outstream.close();
 }
 public void Docfile(String filename) throws IOException
 {
     int i = 0 ;
     n = 0;
     DataInputStream instream = new DataInputStream(new FileInputStream(filename));
     try{
         try{
             while(true){
                 String id = instream.readUTF();
                 if(id.equalsIgnoreCase("SGK"))
                 {
                    String idsach = instream.readUTF();
                   String tensach = instream.readUTF();
                   String idtacgia = instream.readUTF();
                   String idnhasanxuat = instream.readUTF();
                   String idloai = instream.readUTF();
                   String idgiamgia = instream.readUTF();
                   int dongia = instream.readInt();
                   int soluong = instream.readInt();
                   String mon = instream.readUTF();
                   String lop = instream.readUTF();
                    dss = Arrays.copyOf(dss,n+1);
                    dss[i] = new Sachgiaokhoa(idsach,tensach,idtacgia,idnhasanxuat,idloai,idgiamgia,dongia,soluong,mon,lop);
                    i++;
                    n++;
                 }
                 else
                 {
                    String idsach = instream.readUTF();
                   String tensach = instream.readUTF();
                   String idtacgia = instream.readUTF();
                   String idnhasanxuat = instream.readUTF();
                   String idloai = instream.readUTF();
                   String idgiamgia = instream.readUTF();
                   int dongia = instream.readInt();
                   int soluong = instream.readInt();
                   int luatuoi = instream.readInt();
                   String chude = instream.readUTF();
                    dss = Arrays.copyOf(dss,n+1);
                    dss[i] = new Truyen(idsach,tensach,idtacgia,idnhasanxuat,idloai,idgiamgia,dongia,soluong,luatuoi,chude);
                    i++;
                    n++;
                 }
                 
                 
             }
             
         }catch(EOFException e){
             
         }
         finally{
             instream.close();
         }
     }catch(FileNotFoundException e)
     {
         
     }
     catch(IOException e)
     {
         
     }
         
    }
 
}
