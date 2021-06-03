package com.miguelaguilar.challenge.utils

enum class DrawablePosition(val position: Int) {
    DRAWABLE_LEFT(0),
    DRAWABLE_TOP(1),
    DRAWABLE_RIGHT(2),
    DRAWABLE_BOTTOM(3)
}

enum class CardType(val color: String) {
    SILVER("gray"),
    GOLD("yellow"),
    PLATINUM("black")
}

enum class SPKeys(val key: String) {
    TUTORIAL("tutorial"),
    USUARIO("usuario"),
    USUARIOMODEL("usuario_model"),
    CASA("casa"),
    TRABAJO("trabajo"),
    NOMBRE("nombre"),
    APELLIDOS("apellidos"),
    FCM("FCM"),
    NOTIFICATIONOBJECT("NOTIFICATIONOBJECT"),
    PAIS("PAIS"),
    FB_TOKEN("FB_TOKEN")
}

enum class imagesKeys(val key: String) {
    antecedentes("antecedentes"),
    comprobante("comprobante"),
    ine("ine"),
    profile("profile")
}

enum class tarjetasDictionary(val key: Int) {
    desconocida(4),
    mastercard(1),
    american(3),
    visa(2)
}

enum class tarjeta(val key: Int, val text: String) {
    AMERICAN_EXPRESS(3, "American Express"),
    DISCOVER(8, "Discover"),
    JCB(6, "JCB"),
    DINERS_CLUB(7, "Diners Club"),
    VISA(2, "Visa"),
    MASTERCARD(1, "MasterCard"),
    UNIONPAY(5, "UnionPay"),
    UNKNOWN(4, "Unknown")
}