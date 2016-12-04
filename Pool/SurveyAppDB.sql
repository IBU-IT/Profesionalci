USE [master]
GO
/****** Object:  Database [SurveyAppdb]    Script Date: 04.12.2016. 23:05:02 ******/
CREATE DATABASE [SurveyAppdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SurveyAppdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\SurveyAppdb.mdf' , SIZE = 4288KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'SurveyAppdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\SurveyAppdb_log.ldf' , SIZE = 1072KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [SurveyAppdb] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SurveyAppdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SurveyAppdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SurveyAppdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SurveyAppdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SurveyAppdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SurveyAppdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [SurveyAppdb] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [SurveyAppdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SurveyAppdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SurveyAppdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SurveyAppdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SurveyAppdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SurveyAppdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SurveyAppdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SurveyAppdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SurveyAppdb] SET  ENABLE_BROKER 
GO
ALTER DATABASE [SurveyAppdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SurveyAppdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SurveyAppdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SurveyAppdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SurveyAppdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SurveyAppdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SurveyAppdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SurveyAppdb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SurveyAppdb] SET  MULTI_USER 
GO
ALTER DATABASE [SurveyAppdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SurveyAppdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SurveyAppdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SurveyAppdb] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [SurveyAppdb] SET DELAYED_DURABILITY = DISABLED 
GO
USE [SurveyAppdb]
GO
/****** Object:  Table [dbo].[Answers]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answers](
	[ID] [int] NOT NULL,
	[QuestionId] [int] NOT NULL,
	[Answer] [varchar](255) NOT NULL,
	[AnswerCounter] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[GenderSelect]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GenderSelect](
	[UserId] [int] NOT NULL,
	[Gender] [char](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Questions]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Questions](
	[ID] [int] NOT NULL,
	[Queston] [varchar](255) NOT NULL,
	[IsClosed] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SubmitedAnswers]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubmitedAnswers](
	[ID] [int] NOT NULL,
	[QuestionId] [int] NOT NULL,
	[UesrId] [int] NOT NULL,
	[Voted] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserInfo]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInfo](
	[UserId] [int] NOT NULL,
	[FirstName] [varchar](30) NOT NULL,
	[LastName] [varchar](40) NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	[Gender] [int] NOT NULL,
	[DateRegistered] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[UserId] [int] NOT NULL,
	[UserRole] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 04.12.2016. 23:05:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](30) NOT NULL,
	[UserPw] [nvarchar](32) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [SurveyAppdb] SET  READ_WRITE 
GO
