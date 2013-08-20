package org.aksw.defacto.evidence;

import org.aksw.defacto.OldDefactoModel;
import org.aksw.defacto.boa.Pattern;
import org.aksw.defacto.ml.feature.fact.AbstractFactFeatures;
import org.aksw.defacto.model.DefactoModel;

import weka.core.Instance;

import com.hp.hpl.jena.rdf.model.Model;

/**
 * 
 * @author Daniel Gerber <dgerber@informatik.uni-leipzig.de>
 */
public class ComplexProof {

    private Instance instance = new Instance(AbstractFactFeatures.factFeatures.numAttributes());
    
    private Pattern pattern;
    private WebSite website;
    private DefactoModel model;

    private String firstLabel;
    private String secondLabel;

    private String proofPhrase;
    private String normalizedProofPhrase;

    private double score = 0D;

	private String smallContext;
	private String taggedSmallContext;

	private String mediumContext;
	private String taggedMediumContext;

	private String largeContext;
	private String taggedLargeContext;

	private String tinyContext;
	private String taggedTinyContext;

    /**
     * boa pattern found
     * 
     * @param firstLabel
     * @param secondLabel
     * @param occurrence
     * @param normalizedOccurrence
     * @param site
     * @param boaPattern
     */
    public ComplexProof(DefactoModel model, String firstLabel, String secondLabel, String occurrence, String normalizedOccurrence, WebSite site, Pattern boaPattern) {
        
        this.model                    = model;
        this.firstLabel               = firstLabel;
        this.secondLabel              = secondLabel;
        this.proofPhrase              = occurrence;
        this.normalizedProofPhrase    = normalizedOccurrence;
        this.website                  = site;
        this.pattern                  = boaPattern;
    }

    /**
     * proof with no boa pattern
     * 
     * @param firstLabel
     * @param secondLabel
     * @param occurrence
     * @param normalizedOccurrence
     * @param site
     */
    public ComplexProof(DefactoModel model, String firstLabel, String secondLabel, String occurrence, String normalizedOccurrence, WebSite site) {
        
        this.model                    = model;
        this.firstLabel               = firstLabel;
        this.secondLabel              = secondLabel;
        this.proofPhrase              = occurrence;
        this.normalizedProofPhrase    = normalizedOccurrence;
        this.website                  = site;
    }

    public String getLanguage(){
    	
    	return this.website.getLanguage();
    }
    
    /**
     * 
     * @return
     */
    public String getProofPhrase() {

        return this.proofPhrase;
    }

    public Instance getFeatures() {

        return instance;
    }

    public WebSite getWebSite() {

        return this.website;
    }

    public Pattern getPattern() {

        return this.pattern;
    }

    public DefactoModel getModel() {

        return this.model;
    }

    public String getNormalizedProofPhrase() {

        return this.normalizedProofPhrase;
    }

    public String getSubject() {

        return this.firstLabel;
    }
    
    public String getObject() {

        return this.secondLabel;
    }

    public void setScore(double score) {

        this.score = score;
    }
    
    public double getScore() {

        return this.score;
    }

	public void setSmallContext(String smallContext) {
		
		this.smallContext = smallContext; 
	}

	public void setMediumContext(String mediumCntext) {
		
		this.mediumContext = mediumCntext;
	}

	public void setLargeContext(String largeContext) {

		this.largeContext = largeContext;
	}

	/**
	 * @return the taggedSmallContext
	 */
	public String getTaggedSmallContext() {
		return taggedSmallContext;
	}

	/**
	 * @param taggedSmallContext the taggedSmallContext to set
	 */
	public void setTaggedSmallContext(String taggedSmallContext) {
		this.taggedSmallContext = taggedSmallContext;
	}

	/**
	 * @return the taggedMediumContext
	 */
	public String getTaggedMediumContext() {
		return taggedMediumContext;
	}

	/**
	 * @param taggedMediumContext the taggedMediumContext to set
	 */
	public void setTaggedMediumContext(String taggedMediumContext) {
		this.taggedMediumContext = taggedMediumContext;
	}

	/**
	 * @return the taggedLargeContext
	 */
	public String getTaggedLargeContext() {
		return taggedLargeContext;
	}

	/**
	 * @param taggedLargeContext the taggedLargeContext to set
	 */
	public void setTaggedLargeContext(String taggedLargeContext) {
		this.taggedLargeContext = taggedLargeContext;
	}

	/**
	 * @return the smallContext
	 */
	public String getSmallContext() {
		return smallContext;
	}

	/**
	 * @return the mediumContext
	 */
	public String getMediumContext() {
		return mediumContext;
	}

	/**
	 * @return the largeContext
	 */
	public String getLargeContext() {
		return largeContext;
	}

	public void setTinyContext(String tinyContext) {
		
		this.tinyContext = tinyContext;
	}
	
	public String getTinyContext() {
		
		return this.tinyContext;
	}

	/**
	 * @return the taggedTinyContext
	 */
	public String getTaggedTinyContext() {
		return taggedTinyContext;
	}

	/**
	 * @param taggedTinyContext the taggedTinyContext to set
	 */
	public void setTaggedTinyContext(String taggedTinyContext) {
		this.taggedTinyContext = taggedTinyContext;
	}
}
