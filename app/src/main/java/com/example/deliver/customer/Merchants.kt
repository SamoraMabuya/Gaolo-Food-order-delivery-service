package com.example.deliver.customer

class Merchants {

    var name: String? = null;
    var hours: String? = null;
    var phone: String? = null;
    var img: String? = null;

    constructor() {

    }

    constructor(name: String?, hours: String?, phone: String?, img: String?) {
        this.name = name
        this.hours = hours
        this.phone = phone
        this.img = img
    }
}