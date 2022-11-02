package ru.croc.task4.items;

import ru.croc.task3.items.Point;

public class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public Annotation findByPoint(Point point){
        for (Annotation annotation: annotations){
            for(Point currentPoint: annotation.getPoints()){
                if (currentPoint.equals(point)){
                    return annotation;
                }
            }
        }
        return null;
    }

    public Annotation findByPoint(double x, double y){
        return findByPoint(new Point(x, y));
    }

    public Annotation findByLabel(String label){
        for (Annotation annotation: annotations){
            if (annotation.getSignature().equals(label)){
                return annotation;
            }
        }
        return null;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }
}
