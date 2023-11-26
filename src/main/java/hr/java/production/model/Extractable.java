package hr.java.production.model;

import hr.java.production.exception.ExtractException;

public interface Extractable {
    Object extract(String fieldName) throws ExtractException;
}
