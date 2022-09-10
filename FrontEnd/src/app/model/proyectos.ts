export class Proyectos {
    id?: number;
    nombreP: string;
    descripcionP: string;
    imgP: string;
    linkP: string;

    constructor(nombreP: string, descripcionP: string, imgP: string, linkP: string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
        this.linkP = linkP;
    }
}
