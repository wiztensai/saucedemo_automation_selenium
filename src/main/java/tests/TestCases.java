package tests;

import cores.base.BaseTestMultidriver;
import cores.driver.AppDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class TestCases extends BaseTestMultidriver{

    private String username ="";
    private String password="";
    private String hargaBarangSauceLab="";

    @Test(priority = 1)
    public void bukaWebsite() {
        var driver = AppDriver.getDriver();
        // Buka URL
        driver.get("https://www.saucedemo.com/");
        // Verifikasi halaman login ditampilkan
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 2)
    public void simpanUsernameAndPassword() {
        LoginPage loginPage = new LoginPage();
        username = loginPage.getUsername();
        password = loginPage.getPassword();

        // Verifikasi username & password tidak kosong
        Assert.assertNotEquals(username, "");
        Assert.assertNotEquals(password, "");
    }

    @Test(priority = 3)
    public void loginMenggunakanVariabelYangDisimpan() {
        LoginPage loginPage = new LoginPage();

        // Masukkan username dan password
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);

        // Klik tombol login
        loginPage.clickBtnLogin();

        // Verifikasi login berhasil dengan memeriksa judul halaman produk
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productPage.getPageTitle(), "Products");
    }

    @Test(priority = 4)
    public void getHargaProduk() {
        ProductPage productPage = new ProductPage();
        // Temukan harga produk (Sauce Labs Backpack)
        hargaBarangSauceLab = productPage.getPriceText();

        // Verifikasi harga barang yang disimpan tidak kosong
        Assert.assertNotEquals(hargaBarangSauceLab, "");
    }

    @Test(priority = 5)
    public void verifikasiHargaDiHalCheckout() {
        ProductPage productPage = new ProductPage();

        // Klik produk (Sauce Labs Backpack)
        productPage.clickSauceLabsProduct();

        // Klik tombol Add to Cart
        ProductDetailPage productDetailPage = new ProductDetailPage();
        productDetailPage.clickBtnAddToCart();

        // Klik ikon keranjang belanja
        productDetailPage.clickBtnShoppingCart();

        // Verifikasi harga barang sama dengan harga yang disimpan di variabel
        CheckoutPage checkoutPage = new CheckoutPage();
        Assert.assertEquals(checkoutPage.getPriceText(), hargaBarangSauceLab);
    }

    @Test(priority = 6)
    public void checkout() {
        CheckoutPage checkoutPage = new CheckoutPage();

        // Klik tombol Checkout
        checkoutPage.clickBtnCheckout();

        // Mengisi formulir checkout
        CheckoutFormPage checkoutFormPage = new CheckoutFormPage();

        checkoutFormPage.inputFirstName("Nanang");
        checkoutFormPage.inputLastName("Fitrianto");
        checkoutFormPage.inputPostalCode("12630");

        // Klik tombol Continue
        checkoutFormPage.clickBtnContinue();

        // Klik tombol Finish
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.clickBtnFinish();

        // Verifikasi pesanan sudah dikirim
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        Assert.assertTrue(checkoutCompletePage.getCheckoutInformation().contains("Your order has been dispatched"));
    }
}
