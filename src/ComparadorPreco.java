public class ComparadorPreco {
    private Double maior;
    private Double media;
    private Double menor;

    public ComparadorPreco(Double maior,Double media,Double menor){
        setMaior(maior);
        setMedia(media);
        setMenor(menor);
    }

    public Double getMaior() {
        return maior;
    }
    public void setMaior(Double maior) {
        this.maior = maior;
    }
    public Double getMedia() {
        return media;
    }
    public void setMedia(Double media) {
        this.media = media;
    }
    public Double getMenor() {
        return menor;
    }
    public void setMenor(Double menor) {
        this.menor = menor;
    }


    @Override
    public String toString() {
        return "\nMaior: " + maior + "\nMedia: " + media + "\nMenor: " + menor + "\n---------------";
    }
}