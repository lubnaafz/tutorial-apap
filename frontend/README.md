# Tutorial APAP
## Authors
* **Lubna Fairuz Zafira** - *1806235624* - *A*

## Tutorial 7
### What I have learned today
### Github

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
   ______Soal 1 membuat fungsi event callback bernama handleDeleteItemFromCart
   dan addItemToList di component Home yang kemudian di render pada component home. Pada fungsi event tersebut, fungsi handleDeleteItemFromCart akan melakukan penghapusan component item pada cart dengan mengganti elemen inCart pada item tersebut. Kemudian, pada addItemToList akan melakukan penambahan item ke daftar list halaman umum sehingga dapat dilakukan pembelanjaan lagi. Fungsi ini addItemToList  akan dipanggil pada fungsi handleDeleteItemFromCart.
   _____Soal2 membuat fungsi event callback bernama handleBalanceuntuk melakukan perhitungan dari setiap item yang diklik oleh user. Sedemikian sehingga apabila inCart=true atau user sedang menambah keranjang maka saldo balance akan berkurang sesuai harga item yang dipilih tersebut. Fungsi ini juga akan di-render pada component home setiap user melakukan penambahan keranjang atau penghapusan keranjang.
   _____Soal3 menambahkan fungsi alert di dalam fungsi handleBalance. Penambahan ini terlebih dahulu dicek sebelum melakukan penambahan item, apakah saldo bernilai negatif atau tidak. Apabila iya maka muncul alert tersebut.


2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
   ______State adalah data yang tersimpan pada component dan nilainya hanya relevan dengan components tersebut.
   ______Props adalah data yang tersimpan pada suatu component yang dapat ditangani di luar komponen tersebut. Secara umum, perbedaan mendasarnya adalah pada penggunaan datanya, state bersifat private atau hanya dapat digunakan di internal component itu sendiri, sedangkan props dapat digunakan atau berkomunikasi ke component lain.


3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
   ______Ya, karena component dapat lebih mempermudah pemanggilan suatu elemen yang diwakilkan oleh component tersebut. Misal pada tutorial ini terdapat elemen price pada masing-masing produk, informasi price sangat dibutuhkan (di-render di beberapa bagian HTML) sehingga akan lebih mudah apabila setiap atribut tersebut direpresentasikan dengan component.


4. Apa perbedaan class component dan functional component?
   ______Class component (stateful components) dapat menggunakan state dan props
   ______Functional component (stateless components) dapat menggunakan props saja. Selain itu, penerapan functional component lebih ringkas.


5. Dalam react, apakah perbedaan component dan element?
   ______Element merupakan bagian terkecil dari React JS yang dapat dilihat secara langsung oleh user. Elemen ini dapat disebut sebagai representasi virtual dari DOM
   ______Component merupakan bagian-bagain dari tampilan HTML yang dapat digunakan kembali, dimana component ini dapat menerima input berupa props dan me-return emelent untuk dapat dilihat oleh user.

