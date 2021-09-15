# Tutorial APAP
## Authors
* **Lubna Fairuz Zafira** - *1806235624* - *A*

## Tutorial 1
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

