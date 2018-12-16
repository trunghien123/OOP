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

public class Danhsachthongtingiamgia {
 private Thongtingiamgia [] dsttgg = new Thongtingiamgia[1];
 private int n;
 public Danhsachthongtingiamgia() {}
 public Danhsachthongtingiamgia(int n, Thongtingiamgia [] a)
 {
	 this.n=n;
	 this.dsttgg=Arrays.copyOf(a,n);
 }
 public Danhsachthongtingiamgia(Danhsachthongtingiamgia ttgg)
 {
	 this.n=ttgg.n;
	 this.dsttgg = Arrays.copyOf(ttgg.dsttgg, n);
 }
 public void Nhap()
 {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Nhap vao so luong thong tin giam gia: ");
	 this.n= in.nextInt();
	 dsttgg = Arrays.copyOf(dsttgg, n);
	 for(int i=0 ; i<n;i++)
	 {
		 dsttgg[i] = new Thongtingiamgia();
		 dsttgg[i].Nhap();
	 }
 }
 public void Xuat()
 {
	 System.out.printf("\n|%-100s","________________________________________________________________________________________________");
	 System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|","Magiamgia","Masach","Dotgiamgia","Batdau","Ketthuc","Maloaigiamgia");
	 System.out.printf("\n|%-100s","------------------------------------------------------------------------------------------------");
	for(int i=0;i<n;i++)
	{
		dsttgg[i].Xuat();
		System.out.printf("\n|%-100s","------------------------------------------------------------------------------------------------");
	}
 }
 public void Xoavt(int vitrixoa)
 {
	 for(int i=vitrixoa; i<n-1; i++)
	 {
		 dsttgg[i] = dsttgg[i+1];
	 }
	// dsttgg = Arrays.copyOf(dsttgg, n-1);
	 n--;
 }
 //Xoa theo ma giam gia
 public void Xoatheoma()
 {
	 String ma;
	 Scanner in = new Scanner(System.in);
	 System.out.println("\nMoi ban nhap vao ma de xoa: ");
	 ma= in.nextLine();
	 for(int i=0; i<n;i++)
	 {
		 if(dsttgg[i].getMagiamgia()==ma);
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
	 String magiamgiamoi;
	 String masachmoi;
	 String dotgiamgiamoi;
	 String batdaumoi;
	 String ketthucmoi;
	 String maloaigiamgiamoi;
	 for(int i=0;i<n;i++)
	 {
		 if(dsttgg[i].getMagiamgia().equals(ma))
		 {
			 int luachon;
			 while(true)
			 {
				 System.out.println("\n1.Sua ma giam gia.");
				 System.out.println("\n2.Sua ma sach.");
				 System.out.println("\n3.Sua dot giam gia.");
				 System.out.println("\n4.Sua ngay bat dau.");
				 System.out.println("\n5.Sua ngay ket thuc.");
				 System.out.println("\n6.Sua ma loai giam gia.");
				 System.out.println("\n7.Thoat.");
				 System.out.println("\nMoi ban nhap vao lua chon: ");
				 luachon= in.nextInt();
				 in.nextLine();
				 if(luachon<1 || luachon>7)
				 {
					 System.out.println("\nMoi ban nhap dung lua chon. Cam on!!!");
				 }
				 if(luachon==1)
				 {
					 System.out.println("\nMoi ban nhap vao ma giam gia moi: ");
					 magiamgiamoi=in.nextLine();
					 dsttgg[i].setMagiamgia(magiamgiamoi);
				 }
				 else if(luachon==2)
				 {
					 System.out.println("\nMoi ban nhap vao ma sach moi: ");
					 masachmoi=in.nextLine();
					 dsttgg[i].setMasach(masachmoi);
				 }
				 else if(luachon==3)
				 {
					 System.out.println("\nMoi ban nhap vao dot giam gia moi: ");
					 dotgiamgiamoi=in.nextLine();
					 dsttgg[i].setDotgiamgia(dotgiamgiamoi);
				 }
				 else if(luachon==4)
				 {
					 System.out.println("\nMoi ban nhap vao ngay bat dau moi: ");
					 batdaumoi=in.nextLine();
					 dsttgg[i].setBatdau(batdaumoi);
				 }
				 else if(luachon==5)
				 {
					 System.out.println("\nMoi ban nhap vao ngay ket thuc moi: ");
					 ketthucmoi=in.nextLine();
					 dsttgg[i].setKetthuc(ketthucmoi);
				 }
				 else if(luachon==6)
				 {
					 System.out.println("\nMoi ban nhap vao ma loai giam gia moi: ");
					 maloaigiamgiamoi=in.nextLine();
					 dsttgg[i].setMaloaigiamgia(maloaigiamgiamoi);
				 }
				 else if(luachon==7)
				 {
					 System.out.println("\nBan da thoat sua thanh cong.");
					 break;
				 }
			 }
		 }
	 }
 }
 public void Them()
 {
	 dsttgg = Arrays.copyOf(dsttgg, n+1);
	 dsttgg[n] = new Thongtingiamgia();
	 dsttgg[n].Nhap();
	 n++;
 }
 //Them nhieu phan tu
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
// Tim kiem theo ma giam gia
// chua hoan thanh
 public void Timkiemtheoma()
 {
	 String ma;
	 System.out.println("\nNhap vao ma can tim kiem: ");
	 Scanner in =new Scanner(System.in);
	 ma = in.nextLine();
	 	System.out.printf("\n|%-100s","________________________________________________________________________________________________");
	 	System.out.printf("\n|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|","Magiamgia","Masach","Dotgiamgia","Batdau","Ketthuc","Maloaigiamgia");
	 	System.out.printf("\n|%-100s","------------------------------------------------------------------------------------------------");
		 for(int i=0 ; i<n ;i++)
		 {
			 if(dsttgg[i].getMagiamgia().equals(ma));
			 {
				 dsttgg[i].Xuat();
				 System.out.printf("\n|%-30s","------------------------------------------------------------------------------------------------");
			 }
		 }
 }
 public void ghifile(String filename) throws FileNotFoundException, IOException
 {
	 DataOutputStream outstream = new DataOutputStream(new FileOutputStream(filename));
	 for(int i=0;i<n ;i++)
	 {
		 dsttgg[i].Ghifile(filename);
	 }
	 outstream.close();
 }
 public void docfile(String filename)
 {
	 int i=0;
	 int n=0;
	 try {
		 DataInputStream instream = new DataInputStream(new FileInputStream(filename));
		 try {
			 while(true)
			 {
				 String magiamgia = instream.readUTF();
				 String masach = instream.readUTF();
				 String dotgiamgia = instream.readUTF();
				 String batdau = instream.readUTF();
				 String ketthuc = instream.readUTF();
				 String maloaigiamgia = instream.readUTF();
				 dsttgg = Arrays.copyOf(dsttgg, n+1);
				 dsttgg[i] = new Thongtingiamgia(magiamgia,masach,dotgiamgia,batdau,ketthuc,maloaigiamgia);
				 i++;
				 n++;
			 }
		 }catch(EOFException e) {}
		 finally {
			 instream.close();
		 }
	 }catch(FileNotFoundException e)
	 {
		 System.out.println("IOEROR: "+filename+"Not Found: ");
	 }catch(IOException e)
	 {
		 System.out.println("IOERROR: "+e.getMessage()+"\n");
	 }
 }
}
