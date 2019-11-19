package ma.aui.sse.it.xcommerce.monolithic.data.entities;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;;

/**
 *
 * @author Omar IRAQI
 */
@Entity
public class Review extends BaseEntity {

    private static final long serialVersionUID = 8080148085913683937L;

    @ManyToOne
    @NotNull
    private Product product;
    
    @NotNull
    private String eval;

    private float grade;

    protected Review(){ }

    public Review(String eval, float grade, Product product){
        this.eval = eval;
        this.grade = grade;
        this.product = product;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        this.eval = eval;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public Product getProduct() {
        return product;
    }    
}