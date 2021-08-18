package com.halliburton.halliburtonsystem.dto;

import java.io.Serializable;
import java.time.Instant;

public class EmbarkDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant begin;
	private Instant end;
	
	public EmbarkDTO() {
		
	}
	
	public EmbarkDTO(Long id, Instant begin, Instant end) {
		super();
		this.id = id;
		this.begin = begin;
		this.end = end;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getBegin() {
		return begin;
	}

	public void setBegin(Instant begin) {
		this.begin = begin;
	}

	public Instant getEnd() {
		return end;
	}

	public void setEnd(Instant end) {
		this.end = end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmbarkDTO other = (EmbarkDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
