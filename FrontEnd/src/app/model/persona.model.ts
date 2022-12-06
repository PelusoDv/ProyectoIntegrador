export class persona{
    id?: number;
    nombre: string;
    apellido: string;
    img: string;
    titulo: string;
    residencia: string;
    descripcion: string;
    numero: number;
    email: string;

    constructor(nombre: string, apellido: string, img: string, titulo: string, residencia: string,
        descripcion: string, numero: number, email:string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo = titulo;
        this.residencia = residencia;
        this.descripcion = descripcion;
        this.numero = numero;
        this.email = email;
    }
}