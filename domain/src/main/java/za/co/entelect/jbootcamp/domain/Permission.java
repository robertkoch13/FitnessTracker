package za.co.entelect.jbootcamp.domain;

import javax.persistence.*;

@Entity
@Table(name="permission")
public class Permission implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="permission_id")
    private int id;

    private String permission;

    public Permission() {}

    public Permission(int id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission='" + permission + '\'' +
                '}';
    }
}
