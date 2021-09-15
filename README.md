# Tutorial APAP
## Authors
* **Lubna Fairuz Zafira** - *1806235624* - *A*

## Tutorial 2
### What I have learned today
### Github

1. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link
berikut setelah menjalankan program:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%
20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut
dapat terjadi
== Maka Kebun berhasil ditambahkan, hal ini dikarenakan URL tersebut menerima value dari semua atribut kebunSafari melalui @RequsetParam yang telah dibuat pada Controller.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut
merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja
@Autowired tersebut dalam konteks service dan controller yang telah kamu buat
== Pada dasarnya, @Autowired meruapakan anotasi dari Spring itu sendiri yang merupakan bagian dari depenency injection. @Autowired ini akan otomatis mencari method setter getter tanpa perlu dibuat terlebih dahulu oleh developer. Dalam konteks service dan controller, @Autowired akan melihat dalam pakcage dan class-class yang berada dalam anotasi seperti @Controller dan @Service agar kemudian dilakukan inisialisasi dan mengisi (injeksi) kebutuhannya.

3. Cobalah untuk menambahkan sebuah Kebun dengan mengakses link
berikut:
http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung%
20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
==Terjadi error hal ini dikarenakan URL tidak menerima value "noTelepon" padahal RequestMapping di controller pada value "noTelepon" memiliki required "True" yang artinya value tersebut wajib untuk diisi atau berada pada URL. Jika tidak ada maka method yang telah diinisiasi tersebut tidak dapat berjalan. 

4. Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP,
link apa yang harus diakses?
Karena pada nomor 1 berhasil ditambahkan Papa APAP dengan ID 1, maka link yang dapat diakses adalah http://localhost:8080/kebun-safari?id=1

5. Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah
untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga
bukti screenshotmu.
Link tersebut akan menampilkan hasil seluruh object kebunSafari yang berada dalam list. Dalam hal ini, saya telah menambahkan kebunSafari dengan ID 3.
![image](https://user-images.githubusercontent.com/54973570/133474868-c451a4ee-8ba9-466a-8f42-99248342fa65.png)

### What I did not understand
- [ ] Mana yang lebih banyak diimplementasikan pada umumnya, @RequestParam ataukah @PathVariable, mengapa?


## Tutorial 1
### What I have learned today
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker adalah tools yang dapat membantu developer dalam melacak issue yang dibuat dengan sesama developernya. Adapun issue tersebut dapat berupa tugas, ide, solusi, dan lain-lain, sehingga jika suatu saat terdapat issue baru, maka issue lain masih tersimpan dan developer dapat memprioritaskan issue mana yang perlu ditindaklanjuti lebih dahulu. Masalah yang dapat diselesaikan dengan Issue Tracker dapat berupa bugs, enhanchment, pembagian tugas, serta ide improvement.
2. Apa perbedaan dari git merge dan git merge --squash?
git merge --squash memungkinkan hasil penggabungan branch tetap dapat dilakukan namun tampilan branch yang baru dapat merubah dan menggeser branch yang lama. Sementara itu, git merge memungkin kedua branch terintegrasi menjadi suatu tampilan yang terunifikasi.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
Adanya VCS dapat membantu meminimalisir kesalahan akibat human error karena VCS mampu melacak perubahan kode sehinga suatu konflik dapat dicegah. Selain itu, VCS memungkikan developer dalam mengelola kode aplikasi kapan saja dan dimana saja serta dapat membantu developer bekerja antar tim dalam mengembangkan aplikasi.

### Spring
4. Apa itu library & dependency?
Library adalah kumpulan kode dengan beragam fungsi di dalamnya yang dapat digenerate untuk mengembangkan suatu kode. Sementara itu, dependecy adalah teknik untuk membantu developer dalam menggunakan object yang dibuat menjadi parameter di constructor.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven meruapakn sebuah tools yang menggunakan konsep Project Object Model (POM), dimana Maven akan membuat struktur projectnya sendiri dna dapat digunakan dari berbagai jenis IDE. Kita pmenggunakan Maven untuk memerpmudah pembuatan project serta mempermudah mengatur depenecy. Alternatif dari Maven adalah Ant.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
framework?
Beberapa hal yang dapat dikembangkan dengan Spring adalah membantu mengembangkan sistem kemananan yang terkait dengan big data serta dapat membantu mengembangkan enteprise application dengan (Plain Old Java Object). 
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
@RequestParam digunakan untuk nilai yang statis, dan @PathVariable digunakan untuk nilai yang dinamis. Perbedaannya lainnya yaitu @PathVariable memungkinkan anotasi multiple, namun setiap metode perlu memiliki pola yang unik.
@RequestParam sebaiknya digunakan ketika membutuhkan parameter dari URI, sementara itu @PathVariable dapat digunakan apabila membutuhkan nilai placehorder dari URI.


### What I did not understand
- [ ] Kenapa saya harus belajar APAP?
- [ ] Apa yang terjadi apabila tidak mencantumkan URI pada html padahal menggunakan URI tersebut?
- [ ] Mengapa XAMPP harus selau di start pada bagian Apache dan mySQL?


(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))
