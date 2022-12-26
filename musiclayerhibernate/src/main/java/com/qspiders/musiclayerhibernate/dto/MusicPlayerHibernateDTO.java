package com.qspiders.musiclayerhibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SongDetails")
public class MusicPlayerHibernateDTO {

	@Id
	private int id;
	private String songName;
	private String singerName;
	private String movieName;
	private String composer;
	private String lyricist;
	private double length;
	

}
