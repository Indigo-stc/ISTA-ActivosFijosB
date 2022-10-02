package ista.activosfijos.api.models.entity.primary;

public class FileResponse {

    private long id_documento;
    private String nombre_documento;
    private Long size;
    private String url;
    private String contentType;


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

	public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}