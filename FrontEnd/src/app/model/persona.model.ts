export class persona{
    id?: Number;
    nombre: string;
    apellido: string;
    img: string;
    titulo: string;
    residencia: string;
    descripcion: string;

    constructor(nombre: string, apellido: string, img: string, titulo: string, residencia: string, descripcion: string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.residencia = residencia;
        this.descripcion = descripcion;
    }
}