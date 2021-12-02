# Tutorial APAP
## Authors
* **Lubna Fairuz Zafira** - *1806235624* - *A*

## Tutorial 8
### What I have learned today
### Github

1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
   
   Pertama membuat component search terlebih dahulu agar dapat digunakan pada app dengan memanggil <search> saja kemudian mengisi props yang sesuai. DImana pada component search ini dilakukan pencarian berdasarkan judul item. Selain itu dibuat juga props filteredItem untuk menampilkan item berdasarkan field pada search bar nya. Langkah-langkah ini perlu dilakukan agar memudahkan dalam penerapan fitur search pada halaman dan fungsi yang berbeda, sehingga apabila diperlukan maka cukup memanggil component nya saja.


2. Jelaskan fungsi dari async dan await!
   
   async berfungsi untuk mendeklarasikan async function, dimana function ini nantinya akan mengembalikan nilai yang seharusnya atau bisa juga menolak dengan uncaught errors. Sementara itu, await bertugas untuk memberi tahu program agar exit sementara dari async function untuk kemudian dilanjutkan lagi saat tugas yang diberikan selesai. Fungsi ini hanya dapat digunakan pada fungsi async.


3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini.


4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount. Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.

____________componentDidMount: berfungsi untuk mengambil data dan menjalankan action setelah seluruh component berhasil dibuat. Component ini dipanggil setelah tahapan loading dari HTML yang dirender ke DOM. Use case yang biasanya dipakai adalah saat mounting atau inisialisasi props.

____________shouldComponentUpdate: berfungsi untuk memastikan re-rendering yang mungkin terjadi, component ini menentukan apakah suatu perubahan yang terjadi akan ditampilkan.  Component ini dipanggil setelah props atau state mengalami perubahan. Use case yang biasanya dipakai adalah fungsi update yang cenderung akan melakukan rendering dari setiap state.

____________componentDidUpdate: berfungsi untuk melakukan interaksi dengan browser. Component ini dipanggil setelah suatu component di-render ulang. Use case yang biasanya dipakai adalah fungsi update yang perlu dilakukan diluar environment react.

____________componentWillReceiveProps: berfungsi untuk mengubah state berdasarkan state dan props yang baru. Component ini dipanggil apabila component telah menerima nilai props yang baru atau yang telah diubah. Use case yang biasa digunakan adalah saat proses update yang mempengaruhi nilai props.

____________componentWillUnmount: berfungsi untuk melakukan cleanup atau pembersihan yang diperlukan di akhir masa lifecycle. Component ini dipanggil pada proses penghapusan component dari DOM. Use case yang biasa digunakan adalah proses penghapusan list item yang tersedia.
