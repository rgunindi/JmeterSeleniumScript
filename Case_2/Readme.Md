## Case 2 Jmeter

```diff
- Projemizde chromedriver.exe dosya yolu ve Urunler.csv dosya yolu dinamik olarak BaseDir() methodu ile alinmaktadir. 
- Bu yuzden chromedriver.exe ve Urunler.csv dosyalari urunScript.jmx dosyasi ile ayni klasorde bulunmalidir. 
```
Dinamik dosya yolunu alan path kodu:

```
${__BeanShell(import org.apache.jmeter.services.FileServer; FileServer.getFileServer().getBaseDir())}
```

---
> **NOTE**

Testler çalıştırılırken dikkat edilmesi gereken bir husus vardır: 
Guest user olarak aynı IP adresinden çok sayıda hatalı ödeme işlemi yapılmaya çalışıldığında, n11 güvenlik sebebiyle <ins>Captcha sistemini otomatik olarak devreye aldığından ödeme adımlarının test işlemleri tamamlanamayacaktır.</ins> 

---
