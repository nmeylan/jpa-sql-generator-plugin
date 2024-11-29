package ch.nmeylan.plugin.jpa.generator.model;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiType;

import java.util.ArrayList;
import java.util.List;

public class EntityField {
    private final String name;
    private final PsiType type;
    private final PsiField psiField;
    private final PsiClass ownerClass;
    private List<EntityField> relationFields;
    private final EntityField parentRelation;
    private boolean isCollection;

    public EntityField(String name, PsiField psiField, PsiType type, PsiClass ownerClass, EntityField parentRelation) {
        this.name = name;
        this.psiField = psiField;
        this.type = type;
        this.ownerClass = ownerClass;
        this.parentRelation = parentRelation;
        isCollection = false;
    }

    public String getName() {
        return name;
    }

    public PsiClass getOwnerClass() {
        return ownerClass;
    }

    public PsiType getType() {
        return type;
    }

    public PsiField getPsiField() {
        return psiField;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public EntityField setCollection(boolean collection) {
        isCollection = collection;
        return this;
    }

    public List<EntityField> getMutRelationFields() {
        if (relationFields == null) {
            relationFields = new ArrayList<>();
        }
        return relationFields;
    }

    public List<EntityField> getRelationFields() {
        return relationFields;
    }

    public EntityField getParentRelation() {
        return parentRelation;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (type != null) {
            sb.append(type.toString()).append(" ");
        }
        sb.append(name);
        return sb.toString();
    }

}
