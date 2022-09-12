export class Skills {
    id?: number;
    nombreS: string;
    percent: number;

    constructor(nombreS: string, percent: number) {
        this.nombreS = nombreS;
        this.percent = percent;
    }
}
