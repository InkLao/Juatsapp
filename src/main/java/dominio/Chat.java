/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author eduar
 */
@Entity
@Table(name="chats")
public class Chat implements Serializable {

    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Nombre del chat

    @Lob // Tipo Large Object para la imagen
    private byte[] imagenChat; // Imagen del chat

    @ManyToMany
    @JoinTable(
        name = "chat_usuarios",
        joinColumns = @JoinColumn(name = "chat_id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> usuarios; // Usuarios en el chat

    @OneToMany(mappedBy = "chat")
    private Set<Mensaje> mensajes; // Mensajes en el chat
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagenChat() {
        return imagenChat;
    }

    public void setImagenChat(byte[] imagenChat) {
        this.imagenChat = imagenChat;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(Set<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Chat[ id=" + id + " ]";
    }
    
}
