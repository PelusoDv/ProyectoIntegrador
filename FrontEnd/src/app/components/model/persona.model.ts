export class persona{
    id?: Number;
    nombre: String;
    apellido: String;
    img: String;

    constructor(nombre: String, apellido: String, img: String) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img
    }
}