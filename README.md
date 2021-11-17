# Tutorial APAP
## Authors
* **Lubna Fairuz Zafira** - *1806235624* - *A*

## Tutorial 5
### What I have learned today
### Github

1. Apa itu Postman? Apa kegunaannya? 
=== postman adalah sebuah aplikasi sebagai REST CLIENT yang berfungsi untuk membantu para developer melakukan percobaan API di dalamnya. Pada tutorial kali ini digunakan fitur Collection

2. Jelaskan fungsi dari anotasi @ dan @JsonProperty. 
=== Anotasi @JsonIgnoreProperties untuk mengabaikan atribut yang sebenarnya diperlukan untuk memetakan hasil format JSON. Anotasi @JsonProperty untuk membantu memetakan nama atribut dengan menggunakan format JSON.

3. Apa kegunaan atribut WebClient? 
WebClient adalah interface yang berfungsi sebagai first point dalam melakukan web request. Biasanya webClient digunakan untuk memanggil remote REST Services, membandingkan RestTemplate sehingga client dapat lebih reaktif

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity untuk representasi HTTP response: status code, headers, dan body. Digunakan pada method @RestController yang dikembalikan berupa tipe data yang diinginkan. 
BindingResult adalah objek pada Spring, berfungsi untuk menyimpan hasil validasi dan binding serta kemungkinan error yang terjadi.
=======
1. Jelaskan perbedaan th:include dan th:replace! 
_______ th:include = akan menyisipkan fragment yang ditentukan sebagai body tag hostnya termasuk fragment tag
_______ th:replace = menggantikan host tag dengan fragment yang kemudian akan menghapus host tag dan menambahkan fragment yang ditentukan
2. Jelaskan apa fungsi dari th:object! 
_______ Fungsi dari th:object adalah menentukan yang akan diperoleh dari formulir yang telah dihubungkan
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
_______ Pada dasarnya, * dari th:object berfungsi untuk mengambil semua object, sementara $ dapat mengambil spesifikasi tertentu seperti atribut dari object tersebut.


## Tutorial 3
### What I have learned today
### Github

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table) 
@AllArgsConstructor == Agar dapat menginjeksi konstruktor sehingga pada saat membuat object maka semua nilai diinisialisasi
@NoArgsConstructor == Agar dapat melakukan injeksi dengan setter sehingga saat membuat object maka nilai dan dependensi dapat diperbaharui kemudian dengan menggunakan setter.
@Setter == men-generate method setter tanpa perlu mendefinisikannya method setter
@Getter == men-generate method getter tanpa perlu mendefinisikannya method setter
@Entity == untuk dapat menyimpan data dari database yang kemudian dapat direpresentasikan dalam object-oriented
@Table == untuk dapat melakukan pemetaan entity dan juga relasional pada database

2.Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method tersebut? 
Untuk mencari cabang berdasarkan nomor cabang yang didapatkan dari parameter method tersebut kemudian hasil temuan data cabang tersebut disimpan (bisa dalam variable). Pada dasarnya method tersebut merupakan method bawaan dari JPA repository. Pada implementasi tutorial-3 sendiri, method tersebut akan dipanggil untuk memudahkan mendapatkan data Cabang berdasarkan NoCabang.

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn 
@JoinTable akan membuat tabel terpisah untuk menyimpan hubungan 2 tabel, sementara @JoinColumn akan menentukan id dari target tabel entitasnya. Dengan kata lain, @JoinTable menyimpan id dari kedua tabel ke dalam tabel terpisah dan @JoinColumn menyimpan id dari tabel lain di kolom baru.

4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull 
name == menyimpan nama kolom yang berisi id dari tabel lain dengan nama “noCabang”
referencedColumnName ==  mendefinisikan nama tabel yang dimaksud untuk kemudian id nya dapat tersimpan di kolom yang telah didefinisikan pada bagian nama.
nullable == memastikan apakah informasi id pada kolom penyimpan tersebut boleh berisikan informasi null (kosong) atau tidak. Dalam kasus ini, tidak boleh ada informasi yang kosong. Perbedaannya dengan @NotNull adalah pada jenis kolomnya, dimana @NotNull berfungsi untuk memastikan kolom pada tabel saat insiatasi data tersebut berisi informasi kosong atau tidak. 

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY == jenis fetch ini menandakan bahwa entitas dari child object diambil hanya saat digunakan saja
CascadeType.ALL == sebagai penanda apabila salah satu entitas diubah/dihapus maka akan mempengaruhi seluruh entitas yang berhubungan.dengan entitas tersebut.
FetchType.EAGER == jenis fetch ini menandakan bahwa seluruh entitas dari child object di-load saat dilakukan fetch pada parent object

### What I did not understand
- [ ] Mengapa saat mengisi data (cabang) id yang digenerate melanjutkan dari data yang telah dihapus?


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
