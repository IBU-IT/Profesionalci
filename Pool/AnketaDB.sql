USE [master]
GO
/****** Object:  Database [Anketa]    Script Date: 17.11.2016. 17:26:01 ******/
CREATE DATABASE [Anketa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Anketa', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Anketa.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Anketa_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\Anketa_log.ldf' , SIZE = 1040KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Anketa] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Anketa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Anketa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Anketa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Anketa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Anketa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Anketa] SET ARITHABORT OFF 
GO
ALTER DATABASE [Anketa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Anketa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Anketa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Anketa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Anketa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Anketa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Anketa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Anketa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Anketa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Anketa] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Anketa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Anketa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Anketa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Anketa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Anketa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Anketa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Anketa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Anketa] SET RECOVERY FULL 
GO
ALTER DATABASE [Anketa] SET  MULTI_USER 
GO
ALTER DATABASE [Anketa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Anketa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Anketa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Anketa] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Anketa]
GO
/****** Object:  Table [dbo].[Answers]    Script Date: 17.11.2016. 17:26:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answers](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[QuestionID] [int] NOT NULL,
	[Answer] [nvarchar](200) NOT NULL,
	[Counter] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Questions]    Script Date: 17.11.2016. 17:26:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Questions](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Question] [nvarchar](200) NOT NULL,
	[IsClosed] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserRoles]    Script Date: 17.11.2016. 17:26:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRoles](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NULL,
	[UserRole] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 17.11.2016. 17:26:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](35) NOT NULL,
	[UserPw] [varchar](255) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Answers]  WITH CHECK ADD  CONSTRAINT [FK_Answers_Questions] FOREIGN KEY([QuestionID])
REFERENCES [dbo].[Questions] ([ID])
GO
ALTER TABLE [dbo].[Answers] CHECK CONSTRAINT [FK_Answers_Questions]
GO
ALTER TABLE [dbo].[UserRoles]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[Users] ([ID])
GO
USE [master]
GO
ALTER DATABASE [Anketa] SET  READ_WRITE 
GO
