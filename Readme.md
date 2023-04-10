# MİKROSERVİS İŞLEMLERİ VE NOTLARIM

## 1. Kurulum adımları

    ### 1.1. Boş bir gradle projesi açtık.
    ### 1.2. dependencies.gradle dosyasını kodladık
        #### 1.2.1. ext{} bloğu içerisindeki kütüphaneleri projemize dahil ettik.
        #### 1.2.2. versions{} bloğu içerisindeki kütüphanelerin versiyonlarını belirledik.
        #### 1.2.3. libs{} bloğu içerisinde kullanacağımız kütüphaneleri belirledil.
    ### 1.3. build.gradle dosyasını kodladık, bu dosya içinde tüm alt projelerimizde ortak
    olarak kullanacağımız kütüphaneleri belirledik.
    ### 1.4. uygulamamızın mimarisi gereği ihtiyaç duyduğumuz mikroservisleri belirleyerek onları
    modül olarak ekledik.
    ### 1.5. her bir modül için eklememiz gereken aşağıdaki kod bloğunu
    build.gradle dosyalarına ekledik.
```
    buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${versions.springBoot}")
        }
    }
```
    ### 1.6. tüm modüllerimize monolitik mimaride kullandığımız default kodlamaları ekledik.
    ### 1.7. Eğer bir modül içinde kullanmak istediğimiz özel bağımlılıklar var ise bunları 
    build.gradle dosyalarına ekledik.

## 2. MongoDB Kurulum ve Kullanım

### 2.1. MongoDB Docker üzerinde çalıştırmak

    docker kurulu olan bir sistem üzerinde command satırına girerek aşağıda 
    yeralan komutları yazarak docker üzerinde çalıştırıyoruz.

    > docker run --name dockermongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=BilgeAdmin -e MONGO_INITDB_ROOT_PASSWORD=root -d mongo

### 2.2. MongoDB ye bağlanmak

    DİKKAT!!!
    mongodb kullanırken admin kullanıcısı ve şifrelerini veritabanlarına 
    erişmek için kullanmayınız.
    Yeni bir veritabanı oluşturmak için admin kullanıcısı ile işlem yapılır ve
    bu veritananına atanmak üzere yeni bir kullanıcı oluşturulur. böylelikle
    admin kullanıcısına ihtiyaç kalmadan DB üzerinde işlemler gerçekleştirilir.
    1- Öncelikle bir veritabanı oluşturuyorsunuz. (FacebookDB)
    2- mongosh  kullanarak konsolda 'use DB_ADI' yazıyorsunuz ve ilgili DB ye geçiş yapıyorsunuz
    3- yine aynı ekranda yeni bir kullanıcı oluşturmanız gereklidir. bu kullanıcı yetkili olacaktır.
    db.createUser({
        user: "Java7User",
        pwd: "root",
        roles: ["readWrite", "dbAdmin"]
    })
    -- db.createUser({user: "Java7User",pwd: "root",roles: ["readWrite", "dbAdmin"]})


