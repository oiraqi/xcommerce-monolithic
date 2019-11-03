package ma.aui.sse.it.xcommerce.monolithic.data.entities;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Omar IRAQI
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity extends AbstractAuditable<User,Long> implements Serializable{

    private static final long serialVersionUID = -1152317130147556701L;

    protected boolean active = true;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void toggleActive() {
        this.active = !this.active;
    }
}