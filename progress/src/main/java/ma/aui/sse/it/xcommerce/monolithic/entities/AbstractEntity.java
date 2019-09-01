package ma.aui.sse.it.xcommerce.monolithic.entities;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Omar IRAQI
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable{

    private static final long serialVersionUID = -1152317130147556701L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    protected Date createdDate;

    @LastModifiedDate
    protected Date lastModifiedDate;

    @CreatedBy
    protected String createdBy;
    
    @LastModifiedBy
    protected String lastModifiedBy;

    public Long getId(){
        return id;
    }

    public Date getCreatedDate(){
        return createdDate;
    }

    public Date getLastModifiedDate(){
        return lastModifiedDate;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public String getLastModifiedBy(){
        return lastModifiedBy;
    }
}