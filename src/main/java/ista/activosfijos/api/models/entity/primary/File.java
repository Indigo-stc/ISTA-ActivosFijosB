package ista.activosfijos.api.models.entity.primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Documentos",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id_documento"),
        })
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_documento;

    private String nombre_documento;

    private String contentType;

    private Long size;

    @Lob
    private byte[] data;




    public long getId_documento() {
        return id_documento;
    }

    public void setId_documento(long id_documento) {
        this.id_documento = id_documento;
    }

    public String getNombre_documento() {
        return nombre_documento;
    }

    public void setNombre_documento(String nombre_documento) {
        this.nombre_documento = nombre_documento;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}