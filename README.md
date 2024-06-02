# Final Project Automation Testing SwagLabs dan Api User Controller
Repositori ini menyimpan source code pengujian automation untuk SwagLabs dan Api User Controller

## Software Under Test (SUT)
1. Aplikasi Swag Labs
SUT untuk sistem ini adalah aplikasi Swag Labs pada https://saucedemo.com, sebuah aplikasi web yang menyediakan platform simulasi e-commerce. Pengujian pada aplikasi ini didasarkan pada test case yang ditentukan melalui Figma dan dokumen spesifikasi. Pengujian otomatis akan dilakukan pada aplikasi yang tersedia di https://saucedemo.com. Pengujian bertujuan untuk memastikan bahwa semua fitur utama, seperti login, katalog produk, keranjang belanja, dan proses checkout, berfungsi dengan benar. 
2. API User Controller
SUT (Software Under Test) untuk sistem ini adalah API User Controller  pada website https://dummyapi.io  yang merupakan API publik yang menyediakan data pengguna untuk pengujian dan pengembangan. Sistem ini akan diuji untuk memastikan bahwa semua endpoint API (seperti GET, POST, PUT, DELETE) berfungsi sesuai dengan spesifikasi yang telah ditetapkan. Pengujian akan mencakup verifikasi fungsionalitas setiap endpoint. Method yang dapat diuji diantaranya:

1. GET /user/{id}

    Mengambil data user berdasarkan ID

2. POST /user/create

    Membuat user baru dan mengembalikan data user yang telah dibuat
    Body request (field yang dibutuhkan):

```json

    {
      "firstName": "string",
      "lastName": "string",
      "email": "string"
    }
```
3. PUT /user/{id}
    Memperbarui data user berdasarkan ID dan mengembalikan data user yang telah diperbarui
    Body request: field data user yang akan diubah, kecuali ID dan email

4   DELETE /user/{id}
    Menghapus data user berdasarkan ID dan mengembalikan ID user yang telah dihapus



## Tools yang Digunakan

Tools yang digunakan untuk menyelesaikan projek ini diantaranya adalah sebagai berikut:

* Visual Studio Code IDE
* Java Development Kit (JDK) 8 atau lebih tinggi
* JUnit Jupiter 5.8.0
* Selenium Java 3.141.59
* Cucumber Java 6.11.0
* Cucumber PicoContainer 7.0.0
* Cucumber JUnit 6.11.0
* JUnit Vintage Engine 5.8.0 
* Rest Assured 5.2.0
* Google Chrome Browser dan Chrome Driver 125.0.1
* Git dan Github
* CLI (cmd atau Powershell)

### Struktur Projek
Adapun struktur projek yang diterapkan adalah sebagai berikut:
```
  root
    ├───.idea
    ├───src
    │   ├───main/java/swaglabs
    │   │             └──App.java      
    │   └───test
    │       ├───java
    │       │       ├───apiusercontroller
    │       │       │    └───stepdefs
    │       │       │         ├───CreateUserSteps.java
    │       │       │         ├───DeleteUserSteps.java
    │       │       │         ├───GetUserSteps.java
    │       │       │         └───UpdateUserSteps.java
    │       │       │  
    │       │       └───swaglab
    │       │       |   ├───cucumber
    │       │       |   |    └───stepdefs
    │       │       |   |         ├───AddToCartSteps.java
    │       │       |   |         ├───CheckoutSteps.java
    │       │       |   |         ├───FilterProductSTeps.java
    │       │       |   |         ├───FooterSteps.java
    │       │       |   |         ├───HamburgerMenuSteps.java
    │       │       |   |         ├───LoginSteps.java
    │       │       |   |         ├───RemoveFromCartSteps.java
    │       │       |   |         ├───StepDefManager.java
    │       │       |   |         ├───ViewCartSteps.java
    │       │       |   |         └───ViewProductSteps.java
    │       │       |   └───pom
    │       │       |       ├───model
    │       │       |       ├───pages
    │       │       |       ├───util
    │       │       |       └───ProductsPageTest.java
    │       │       └───RunTest.java   
    │       │           
    │       └───resources
    │           ├───features
    │           │    ├───apiusercontroller
    │           │    │   
    │           │    └───swaglabs
    │           │        
    │           ├───chromedriver.exe
    │           └───geckodriver.exe
    ├───target
    │   ├───classes
    │   ├───maven-status
    │   ├───surefire-reports
    │   ├───test-classes
    │   ├───jsonReport.json
    │   └───testReport.html
    │       
    ├───pom.xml
    └───README.md

```

# Anggota Kelompok

- Helsa Alika Femiani - 211524044
- Novia Nur Azizah - 211524053
- Regi Purnama - 211524057

## Instalasi Project

Langkah-langkah untuk menginstal proyek ini pada lingkungan lokal:

1. Clone repository ini
   ```sh
git clone https://github.com/noviazizah/Final-Project-Testing.git
   ``
2. Masuk ke direktori proyek:
```
cd Final-Project-Testing
```
3. Jalankan pengujian dengan Maven:

```sh
mvn test
```