
/**
 * Enumeração Tipo_dado - escreva a descrição da enumeração aqui
 * 
 * @author (seu nome aqui)
 * @version (número da versão ou data aqui)
 */
public enum Tipo_dado
{
    DADO_4(4),
    DADO_6(6),
    DADO_8(8),
    DADO_20(20),
    DADO_100(100),
    DADO_ERRO(0);

    public final Integer label;

    private Tipo_dado(int label) {
        this.label = label;
    }
}
