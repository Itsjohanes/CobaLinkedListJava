/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author acer
 */
class NilaiMatkul{
    private String nim;
    private String nama;
    private String nilai;
    //setter
    void setNim(String nim){
        this.nim = nim;
    }
    void setNama(String nama){
        this.nama = nama;
    }
    void setNilai(String nilai){
        this.nilai = nilai;
    }
    //getter
    String getNim(){
        return nim;
    }
    String getNama(){
        return nama;
    }
    String getNilai(){
        return nilai;
    }
}
class Elemen{
   private NilaiMatkul kontainer;
   private int next;
   Elemen(){
       kontainer = new NilaiMatkul();
   }
   NilaiMatkul getKontainer(){
       return kontainer;
   }
   void setNext(int next){
       this.next = next;
   }
   int getNext(){
       return next;
   }
}
class List{
    private int first;
    private Elemen[] data = new Elemen[10];//buat 10 elemen
    List(){
        for(int i = 0;i<10;i++){
            data[i] = new Elemen();
        }
    }
    void setFirst(int first){
        this.first = first;
    }
    int getFirst(){
        return first;
    }
    void createList(){
        first = -1;
        int i;
        for( i = 0;i<10;i++){
            data[i].setNext(-2);
        }
    }
    int countElement(){
        int hasil = 0;
        if(first != -1){
            int bantu;
            bantu = first;
            while(bantu != -1){
                hasil  = hasil +1 ;
                bantu = data[bantu].getNext();
            }
        }
        return hasil;
    }
    int emptyElement(){
        int hasil  = -1;
        if(countElement() < 10){
            boolean ketemu  = false;
            int i = 0;
            while(ketemu == false && i<10){
                if(data[i].getNext() == -2){
                    hasil = i;
                    ketemu = true;
                }else{
                    i = i+1;
                }
            }
        }
        return hasil;
    }
    void addFirst(String nim,String nama,String nilai){
        if(countElement() < 10){
            int baru = emptyElement();
            data[baru].getKontainer().setNim(nim);
            data[baru].getKontainer().setNama(nama);
            data[baru].getKontainer().setNilai(nilai);
            
            if(first == -1){
                data[baru].setNext(-1);
                
            }else{
                data[baru].setNext(first);
            }
            first = baru;
        }else{
            System.out.println("tidak dapat ditambahkan");
        }
    }
    void printElement(){
        if(first != -1){
            int bantu = first;
            int i = 1;
        
        while(bantu != -1){
            System.out.println("element ke " + i);
            System.out.println("Nim : " + data[bantu].getKontainer().getNim());
            System.out.println("Nama : " + data[bantu].getKontainer().getNama());
            System.out.println("Nilai : " + data[bantu].getKontainer().getNilai());
            bantu = data[bantu].getNext();
            i = i++;
        }
    }else{
            System.out.println("List Kosong");
        }
   
}
}
public class LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List L  = new List();
        L.createList();
      
        L.addFirst("111","Jontor","70");
        L.addFirst("123","Jones","80");
        L.printElement();
    }
    
}
