package pl.umcs.item.base;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Year;

@Data
@RequiredArgsConstructor
public abstract class WorkOfArt implements Item {
    protected final Year creationYear;
}
